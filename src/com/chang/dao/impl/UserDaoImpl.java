package com.chang.dao.impl;

import com.chang.domain.User;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.UUID;

public class UserDaoImpl extends BaseDao implements com.chang.dao.UserDao {

    @Override
    public void add(User user){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String sql = "insert into user(id, username, password, email, birthday, nikename) values (?,?,?,?,?,?)";
        Object[] params = {UUID.randomUUID().toString(), user.getUsername(),user.getPassword(),user.getEmail(),sdf.format(user.getBirthday()),user.getNikename()};
        this.executeUpdate(sql, params);
    }

    @Override
    public User find(String username, String password){

        User user = new User();

        String sql = "select * from user where username = ? and password = ?";
        Object[] params = {username,password};
        ResultSet rs = this.executeQuery(sql, params);

        try {
            List list = this.ConvertToList(rs, User.class);
            user = (User) list.get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }

    @Override
    public User find(String username){
        User user = null;

        String sql = "select * from user where username = ?";
        Object[] params = {username};
        ResultSet rs = this.executeQuery(sql, params);

        try {
            List list = this.ConvertToList(rs, User.class);
            if(list.size() > 0) user = (User) list.get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }


    @Override
    public void update(User user){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String sql = "update user set username=?, password=?, email=?, birthday=?, nikename=? where id=?";
        Object[] params = {user.getUsername(),user.getPassword(),user.getEmail(),sdf.format(user.getBirthday()),user.getNikename(),user.getId()};
        this.executeUpdate(sql, params);
    }

    @Override
    public void delete(User user){
        String sql = "delete from user where id=?";
        Object[] params = {user.getId()};
        this.executeUpdate(sql, params);
    }
}
