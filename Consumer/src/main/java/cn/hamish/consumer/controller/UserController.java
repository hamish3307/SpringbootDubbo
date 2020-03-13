package cn.hamish.consumer.controller;

import cn.hamish.api.dto.UserDTO;
import cn.hamish.api.dto.UserQueryDTO;
import cn.hamish.api.service.IUserService;
import cn.hamish.common.BaseQueryDTO;
import cn.hamish.common.page.PageDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @描述:
 * @Date: 2020-03-13 17:06
 * @Author: hha
 */
@RestController
@Api(value = "用户信息表", tags = "用户信息")
@RequestMapping("/user")
public class UserController {

    @Reference
    private IUserService userService;

    @ApiOperation(value="测试sayHollo",notes="sayHollo")
    @GetMapping("/sayHello")
    public String sayHollo(@RequestParam("name") String name){
        String hello = userService.sayHello(name);
        return hello;
    }

    @ApiOperation(value="获取用户列表",notes="获取用户列表")
    @PostMapping("/list")
    public PageDTO<UserDTO> getUserList(@RequestBody BaseQueryDTO<UserQueryDTO> queryDTO){
        return userService.getUserList(queryDTO);
    }

    @ApiOperation(value="获取用户详细",notes="获取用户详细")
    @GetMapping("/one")
    public UserDTO getUserInfo(@RequestParam("id") String id){
        return userService.getUserById(id);
    }

}
