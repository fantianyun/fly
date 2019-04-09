package com.fty.service.impl;

import com.fty.entity.User;
import com.fty.service.MyBatisUserService;
import com.fty.service.mybatisInterface.MybatisUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MyBatisUserServiceImpl implements MyBatisUserService {
    @Autowired
    private MybatisUserDao mybatisUserDao = null;

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED,timeout = 1)
    public User getUser(long id) {
        return mybatisUserDao.getUser(id);
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED,timeout = 1)
    public int insertUser(User user) {
        return mybatisUserDao.insertUser(user);
    }

}
