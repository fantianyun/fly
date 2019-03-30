package com.fty.service;

import com.fty.entity.User;

import java.util.List;

public interface JdbcTmplUserService {
    public User getUser(long id);
    public List<User> findUsers(String userName,String note);
    public  int inserUser(User user);
    public  int updateUser(User user);
    public  int deleteUser(long id);
}
