package com.chang.services.impl;

import com.chang.dao.UserDao;
import com.chang.dao.impl.UserDaoImpl;
import com.chang.domain.User;
import com.chang.exception.UserExistException;
import com.chang.services.UserService;
import com.chang.utils.MD5Utils;

import java.util.List;

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

    @Override
    public List<User> getAllUser() {
        return dao.getAllUser();
    }

    @Override
    public User getUser(String id) {
        return dao.getUser(id);
    }

    @Override
    public void deleteUser(String id) {

        dao.delete(id);
    }

    @Override
    public void updateUser(User user) {
        dao.update(user);
    }
}
