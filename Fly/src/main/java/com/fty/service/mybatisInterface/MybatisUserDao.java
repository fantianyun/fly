package com.fty.service.mybatisInterface;

import com.fty.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface MybatisUserDao {
    User getUser(long id);
    int insertUser(User user);
    List<User> getUsers(String userName,String note);
}
