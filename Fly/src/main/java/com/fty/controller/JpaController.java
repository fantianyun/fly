package com.fty.controller;

import com.fty.entity.User;
import com.fty.enumeration.SexEnum;
import com.fty.service.MyBatisUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/jpa")
public class JpaController {
    @Autowired
    private MyBatisUserService myBatisUserService = null;
    @RequestMapping("/getUser")
    @ResponseBody
    public User getUser(Long id){
        User user = myBatisUserService.getUser(id);
        return user;
    }
    @RequestMapping("insertUser")
    @ResponseBody
    private Map<String,Object> insertUser(String UserName,int sex,String note){
        User user = new User();
        user.setUserName(UserName);
        user.setSex(SexEnum.getEnumById(sex));
        user.setNote(note);
        int update = myBatisUserService.insertUser(user);
        Map<String,Object> result = new HashMap<>();
        result.put("success",update == 1);
        result.put("user",user);
        return result;
    }
//    @ResponseBody
//    @RequestMapping("/getUserByUserName")
//    public List<User> getUserByUserName(String userName){
//        List<User> users = jpaUserRepository.findByUserName(userName);
//        return users;
//    }
}
