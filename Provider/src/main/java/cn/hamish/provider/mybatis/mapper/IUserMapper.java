package cn.hamish.provider.mybatis.mapper;

import cn.hamish.api.dto.UserDTO;
import cn.hamish.api.dto.UserQueryDTO;
import cn.hamish.provider.mybatis.provide.UserSqlProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

/**
 * @描述: 用户Mapper
 * @Date: 2020-03-12 14:38
 * @Author: hha
 */
@Mapper
public interface IUserMapper {

    @SelectProvider(type = UserSqlProvider.class, method = "getUserCount")
    long getUserCount(@Param("queryInfo") UserQueryDTO queryInfo);

    @SelectProvider(type = UserSqlProvider.class, method = "getUserList")
    List<UserDTO> getUserList(@Param("queryInfo") UserQueryDTO queryInfo,
                              @Param("start") int start,
                              @Param("rows") int rows);

    @Select("select id,name,age,sex,tel from user where id = #{id}")
    UserDTO getUserById(@Param("id") String id);

}
