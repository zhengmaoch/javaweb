package com.chang.services;

import com.chang.domain.User;
import com.chang.exception.UserExistException;

import java.util.List;

public interface UserService {
    void register(User user) throws UserExistException;

    User login(String username, String password);

    List<User> getAllUser();

    User getUser(String id);

    void deleteUser(String id);

    void updateUser(User user);
}
