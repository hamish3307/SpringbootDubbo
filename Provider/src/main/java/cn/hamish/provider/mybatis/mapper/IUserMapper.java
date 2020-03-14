package cn.hamish.provider.mybatis.mapper;

import cn.hamish.api.dto.UserDTO;
import cn.hamish.api.dto.UserQueryDTO;
import cn.hamish.provider.mybatis.provide.UserSqlProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @描述: 用户Mapper
 * @Date: 2020-03-12 14:38
 * @Author: hha
 */
@Mapper
public interface IUserMapper {

    @SelectProvider(type = UserSqlProvider.class, method = "getUserCount")
    long getUserCount(UserQueryDTO queryInfo);

    @SelectProvider(type = UserSqlProvider.class, method = "getUserList")
    List<UserDTO> getUserList(@Param("queryInfo") UserQueryDTO queryInfo,
                              @Param("start") int start,
                              @Param("rows") int rows);

    @Select("select id,name,age,sex,tel from user where id = #{id}")
    UserDTO getUserById(@Param("id") String id);

    @Insert("insert into user(id,name,age,sex,tel) values(#{id},#{name},#{age},#{sex},#{tel})")
    int save(UserDTO user);

    @Update("update user set name = #{name}, age = #{age}, sex = #{sex},tel = #{tel} where id = #{id}")
    int update(UserDTO user);

    @Delete("delete from user where id = #{id}")
    int delete(String id);

}
