package com.fty.controller;

import com.fty.entity.User;
import com.fty.service.jpaInterface.JpaUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/jpa")
public class JpaController {
    @Autowired
    private JpaUserRepository jpaUserRepository = null;
    @RequestMapping("/getUser")
    @ResponseBody
    public User getUser(Long id){
        User user = jpaUserRepository.findById(id).get();
        return user;
    }
//    @ResponseBody
//    @RequestMapping("/getUserByUserName")
//    public List<User> getUserByUserName(String userName){
//        List<User> users = jpaUserRepository.findByUserName(userName);
//        return users;
//    }
}
