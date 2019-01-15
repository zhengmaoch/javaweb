package com.chang.test;

import com.chang.dao.impl.UserDaoImpl;
import com.chang.domain.User;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

public class UserDaoTest {

    @Test
    public void testAdd(){
        User user = new User();
        user.setUsername("zhangsan");
        user.setPassword("123456");
        user.setNikename("张三");
        user.setEmail("zhangsan@qq.com");
        user.setBirthday(new Date());
        user.setCreatedTime(new Date());

        UserDaoImpl dao = new UserDaoImpl();
        dao.add(user);

        User user1 = dao.find("zhangsan");
        Assert.assertTrue(user1 != null);

        dao.delete(user1);
    }

    @Test
    public void testUpdate(){
        User user = new User();
        user.setUsername("zhangsan");
        user.setPassword("123456");
        user.setNikename("张三");
        user.setEmail("zhangsan@qq.com");
        user.setBirthday(new Date());
        user.setCreatedTime(new Date());

        UserDaoImpl dao = new UserDaoImpl();
        dao.add(user);

        User user1 = dao.find("zhangsan");
        user1.setUsername("lisi");
        dao.update(user1);

        User user2 = dao.find("lisi");
        Assert.assertTrue(user2 != null);
        dao.delete(user2);
    }

    @Test
    public void testFind(){

        User user = new User();
        user.setUsername("zhangsan");
        user.setPassword("123456");
        user.setNikename("张三");
        user.setEmail("zhangsan@qq.com");
        user.setBirthday(new Date());
        user.setCreatedTime(new Date());

        UserDaoImpl dao = new UserDaoImpl();
        dao.add(user);

        User user1 = dao.find("xxx");
        Assert.assertTrue(user1 == null);

        User user2 = dao.find("zhangsan");
        Assert.assertTrue(user2 != null);

        User user3 = dao.find("zhangsan","123456");
        Assert.assertTrue(user3 != null);

        dao.delete(user3);

    }

    @Test
    public void testDelete(){

        User user = new User();
        user.setUsername("zhangsan");
        user.setPassword("123456");
        user.setNikename("张三");
        user.setEmail("zhangsan@qq.com");
        user.setBirthday(new Date());
        user.setCreatedTime(new Date());

        UserDaoImpl dao = new UserDaoImpl();
        dao.add(user);

        User user1 = dao.find("zhangsan");
        dao.delete(user1);
        User user2 = dao.find("zhangsan");
        Assert.assertTrue(user2 == null);
    }
}
