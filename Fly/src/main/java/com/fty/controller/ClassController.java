package com.fty.controller;

import com.fty.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin("*")
public class ClassController {

    @Autowired
    private ClassService ClassService;


    @RequestMapping("getClassData")
    public ResponseEntity getClassData(){
        return  ResponseEntity.ok(ClassService.getClassData());
    }
}
