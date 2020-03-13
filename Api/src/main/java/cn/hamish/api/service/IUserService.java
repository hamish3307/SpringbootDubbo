package cn.hamish.api.service;

import cn.hamish.api.dto.UserDTO;
import cn.hamish.api.dto.UserQueryDTO;

import java.util.List;

/**
 * @描述:
 * @Date: 2020-03-13 15:04
 * @Author: hha
 */
public interface IUserService {

    String sayHello(String name);

    List<UserDTO> getUserList(UserQueryDTO queryDTO, int start, int rows);

    UserDTO getUserById(String id);

}
