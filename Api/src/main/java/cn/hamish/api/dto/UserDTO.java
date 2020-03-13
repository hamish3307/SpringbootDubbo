package cn.hamish.api.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 描述: 用户DTO
 * @Date: 2020-03-12 14:02
 * @Author: hha
 */
@Data
public class UserDTO implements Serializable {

    private static final long serialVersionUID = 8475778474694234894L;
    /* ID */
    private String id;
    /* 姓名 */
    private String name;
    /* 年龄 */
    private int age;
    /* 性别 */
    private String sex;
    /* 电话 */
    private String tel;

}
