package cn.hamish.provider.mybatis.provide;

import cn.hamish.api.dto.UserQueryDTO;
import org.apache.dubbo.common.utils.StringUtils;

import java.util.Map;

/**
 * @描述: 用户动态SQL的Provider
 * @Date: 2020-03-12 17:24
 * @Author: hha
 */
public class UserSqlProvider {

    public String getUserList(Map<String, Object> param){
        UserQueryDTO queryDTO = (UserQueryDTO) param.get("queryInfo");
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT id,name,age,sex,tel FROM user WHERE 1 = 1");
        if (StringUtils.isNotEmpty(queryDTO.getId())) {
            sql.append(" AND id = ").append(queryDTO.getId());
        }
        if (StringUtils.isNotEmpty(queryDTO.getName())) {
            sql.append(" AND name like '%").append(queryDTO.getName()).append("%'");
        }
        sql.append(" limit ").append(param.get("start")).append(", ").append(param.get("rows"));
        return sql.toString();
    }

    public String getUserCount(UserQueryDTO queryDTO){
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT count(*) FROM user WHERE 1 = 1");
        if (StringUtils.isNotEmpty(queryDTO.getId())) {
            sql.append(" AND id = #{id}");
        }
        if (StringUtils.isNotEmpty(queryDTO.getName())) {
            sql.append(" AND name like '%#{id}%'");
        }
        return sql.toString();
    }

}
