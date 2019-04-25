package com.fty.service;

import com.fty.entity.User;

import java.util.List;


public interface MyBatisUserService {
    User getUser(long id);
    int insertUser(User user);
    List<User> getUsers(String userName, String note);
}
