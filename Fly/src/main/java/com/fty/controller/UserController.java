package com.fty.controller;
import com.fty.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService ;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @RequestMapping("/getUser")
    public ResponseEntity<Map<String, Object>> getUserInfo(@RequestParam("code") String code) {
        Map<String, Object> result = userService.code2session(code);
        return ResponseEntity.ok(result);
    }

}
