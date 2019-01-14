package com.chang.services.impl;

import com.chang.dao.UserDao;
import com.chang.dao.impl.UserDaoImpl;
import com.chang.domain.User;
import com.chang.exception.UserExistException;
import com.chang.services.UserService;
import com.chang.utils.MD5Utils;

public class UserServiceImpl implements UserService {

    private UserDao dao = new UserDaoImpl();

    @Override
    public void register(User user) throws UserExistException {
        boolean b = dao.find(user.getUsername()) == null;
        if(b){
            user.setPassword(MD5Utils.md5(user.getPassword()));
            dao.add(user);
        }else{
            throw new UserExistException();
        }
    }

    @Override
    public User login(String username, String password){
        password = MD5Utils.md5(password);
        return dao.find(username,password);
    }
}
