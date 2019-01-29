package com.fty.controller;

import com.fty.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping("/")
    public ResponseEntity<User> hello(){
        User user = new User();
        user.setPassword("147852");
        user.setUsername("yejinyun");
        return  ResponseEntity.ok(user);
    }
}
