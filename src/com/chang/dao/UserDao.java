package com.chang.dao;

import com.chang.domain.User;

public interface UserDao {
    void add(User user);

    User find(String username, String password);

    User find(String username);

    void update(User user);

    void delete(User user);
}
