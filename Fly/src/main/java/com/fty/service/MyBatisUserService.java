package com.fty.service;

import com.fty.entity.User;


public interface MyBatisUserService {
    User getUser(long id);
    int insertUser(User user);
}
