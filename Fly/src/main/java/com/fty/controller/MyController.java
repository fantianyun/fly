package com.fty.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/my")
public class MyController {
    @GetMapping("/no/annotation")
    @ResponseBody
    public Map<String,Object> noAnnotation(@RequestParam(value = "int_val") Integer intValue, Long longValue, String strValue){
        Map<String,Object> params = new HashMap<>();
        params.put("intValue",intValue);
        params.put("longValue",longValue);
        params.put("strValue",strValue);
        return params;
    }
}
