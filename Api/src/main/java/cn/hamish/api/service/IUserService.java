package cn.hamish.api.service;

import cn.hamish.api.dto.UserDTO;
import cn.hamish.api.dto.UserQueryDTO;
import cn.hamish.common.BaseQueryDTO;
import cn.hamish.common.page.PageDTO;

/**
 * @描述:
 * @Date: 2020-03-13 15:04
 * @Author: hha
 */
public interface IUserService {

    String sayHello(String name);

    PageDTO<UserDTO> getUserList(BaseQueryDTO<UserQueryDTO> queryDTO);

    UserDTO getUserById(String id);

}
