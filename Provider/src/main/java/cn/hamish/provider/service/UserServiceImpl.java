package cn.hamish.provider.service;

import cn.hamish.api.dto.UserDTO;
import cn.hamish.api.dto.UserQueryDTO;
import cn.hamish.api.service.IUserService;
import cn.hamish.common.BaseQueryDTO;
import cn.hamish.common.page.PageDTO;
import cn.hamish.provider.mybatis.mapper.IUserMapper;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @描述:
 * @Date: 2020-03-13 15:14
 * @Author: hha
 */
@Service(interfaceClass = IUserService.class)
@Component
public class UserServiceImpl implements IUserService {

    @Resource
    private IUserMapper userMapper;

    @Override
    public String sayHello(String name) {
        return "Hello " + name;
    }

    @Override
    public PageDTO<UserDTO> getUserList(BaseQueryDTO<UserQueryDTO> queryDTO) {
        PageDTO pageDTO = new PageDTO();
        List<UserDTO> userList = userMapper.getUserList(queryDTO.getQueryInfo(), queryDTO.getPageInfo().calStart(), queryDTO.getPageInfo().getPageSize());
        long count = userMapper.getUserCount(queryDTO.getQueryInfo());
        pageDTO.setData(userList);
        pageDTO.setTotalRecords(count);
        return pageDTO;
    }

    @Override
    public UserDTO getUserById(String id) {
        return userMapper.getUserById(id);
    }

}
