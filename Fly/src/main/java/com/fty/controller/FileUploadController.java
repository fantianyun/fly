package com.fty.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/file")
public class FileUploadController {
    @RequestMapping("/uploadform")
    public ModelAndView fileUploadView(){
        return new ModelAndView("index");
    }
    @RequestMapping("/hello")
    public  String hello(){
        return  "fileUpload";
    }
    @RequestMapping(value = "/request",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> uploadRequest(HttpServletRequest request){
        boolean flag = false;
        MultipartRequest mreq = null;
        Map<String,Object> resultMap = new HashMap<>();
        if(request instanceof  MultipartRequest){
            mreq = (MultipartRequest) request;
        }else {
             resultMap.put("false","上传失败");
             return resultMap;
        }
        MultipartFile file = mreq.getFile("file");
        String fileName = file.getOriginalFilename();
        File saveFile = new File(fileName);
        try {
            file.transferTo(saveFile);
        } catch (IOException e) {
            e.printStackTrace();
            resultMap.put("false","上传失败");
            return resultMap;
        }
        resultMap.put("false","上传成功");
        return resultMap;
    }

}
