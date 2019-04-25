package com.fty.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class Validator {
    @RequestMapping(value = "/valid/validate")
    @ResponseBody
    public Map<String,Object> validate(@Valid @RequestBody com.fty.entity.Validator vp, Errors errors){
        Map<String,Object> errMap = new HashMap<>();
        List<ObjectError> oes = errors.getAllErrors();
        for(ObjectError oe : oes){
            String  key = null;
            String msg = null;
            if(oe instanceof FieldError){
                FieldError fe = (FieldError) oe;
                key = fe.getField();
            }else {
                key = oe.getObjectName();
            }
            msg = oe.getDefaultMessage();
            errMap.put(key,msg);
        }
        return errMap;
    }
}
