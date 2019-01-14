package com.chang.test;

import com.chang.domain.User;
import com.chang.exception.UserExistException;
import com.chang.services.UserService;
import com.chang.services.impl.UserServiceImpl;
import org.junit.Test;

import java.util.Date;

public class UserServiceTest {

    @Test
    public void testRegister(){
        User user = new User();
        user.setUsername("zhangsan");
        user.setPassword("123456");
        user.setNikename("张三");
        user.setEmail("zhangsan@qq.com");
        user.setBirthday(new Date());

        UserService service = new UserServiceImpl();

        try {
            service.register(user);
            System.out.println("注册成功！");
        } catch (UserExistException e) {
            System.out.println("用户已存在！");
        }
    }

    @Test
    public void testLogin(){
        UserService service = new UserServiceImpl();
        User user = service.login("zhangsan","123456");
        System.out.println(user);
    }
}
