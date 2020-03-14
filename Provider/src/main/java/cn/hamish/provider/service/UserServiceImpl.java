package cn.hamish.provider.service;

import cn.hamish.api.dto.UserDTO;
import cn.hamish.api.dto.UserQueryDTO;
import cn.hamish.api.service.IUserService;
import cn.hamish.common.BaseQueryDTO;
import cn.hamish.common.page.PageDTO;
import cn.hamish.provider.mybatis.mapper.IUserMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.common.utils.StringUtils;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.BeanUtils;
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
@Slf4j
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

    @Override
    public boolean save(UserDTO user) {
        int i = userMapper.save(user);
        if (i > 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean update(UserDTO user) {
        UserDTO userDTO = userMapper.getUserById(user.getId());
        if (userDTO == null) {
            log.error("不存在需要更新的用户");
            return false;
        }
        // 测试 BeanUtils.copyProperties 对象转换，也可直接赋值
        BeanUtils.copyProperties(userDTO, user);
        int i = userMapper.update(userDTO);
        if (i > 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        int i = userMapper.delete(id);
        if (i > 0) {
            return true;
        }
        return false;
    }

}
