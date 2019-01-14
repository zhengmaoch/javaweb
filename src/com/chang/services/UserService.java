package com.chang.services;

import com.chang.domain.User;
import com.chang.exception.UserExistException;

public interface UserService {
    void register(User user) throws UserExistException;

    User login(String username, String password);
}
