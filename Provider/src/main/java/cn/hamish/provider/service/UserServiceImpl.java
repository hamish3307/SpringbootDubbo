package cn.hamish.provider.service;

import cn.hamish.api.service.IUserService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

/**
 * @描述:
 * @Date: 2020-03-13 15:14
 * @Author: hha
 */
@Service(interfaceClass = IUserService.class)
@Component
public class UserServiceImpl implements IUserService {

    @Override
    public String sayHello(String name) {
        return "Hello " + name;
    }

}
