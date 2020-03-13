package cn.hamish.provider.mybatis.provide;

import cn.hamish.api.dto.UserQueryDTO;
import org.apache.dubbo.common.utils.StringUtils;

/**
 * @描述: 用户动态SQL的Provider
 * @Date: 2020-03-12 17:24
 * @Author: hha
 */
public class UserSqlProvider {

    public String getUserList(UserQueryDTO queryDTO, int start, int rows){
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT id,name,age,sex,tel FROM user WHERE 1 = 1");
        if (StringUtils.isNotEmpty(queryDTO.getId())) {
            sql.append(" AND id = ").append(queryDTO.getId());
        }
        if (StringUtils.isNotEmpty(queryDTO.getName())) {
            sql.append(" AND name like '%").append(queryDTO.getName()).append("%'");
        }
        sql.append(" limit ").append(start).append(", ").append(rows);
        return sql.toString();
    }

    public String getUserCount(UserQueryDTO queryDTO){
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT count(*) FROM user WHERE 1 = 1");
        if (StringUtils.isNotEmpty(queryDTO.getId())) {
            sql.append(" AND id = ").append(queryDTO.getId());
        }
        if (StringUtils.isNotEmpty(queryDTO.getName())) {
            sql.append(" AND name like '%").append(queryDTO.getName()).append("%'");
        }
        return sql.toString();
    }

}
