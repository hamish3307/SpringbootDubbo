package cn.hamish.api.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @描述: 用户查询DTO
 * @Date: 2020-03-12 14:40
 * @Author: hha
 */
@Data
public class UserQueryDTO implements Serializable {

    private static final long serialVersionUID = -1930827402317065577L;
    /* ID */
    private String id;

    /* 姓名 */
    private String name;

}
