package com.fty.service.mybatisInterface;

import com.fty.entity.User;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface MybatisUserDao {
    User getUser(long id);
    int insertUser(User user);
}
