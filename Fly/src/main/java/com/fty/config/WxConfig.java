package com.fty.config;

import org.springframework.stereotype.Component;

@Component
public class WxConfig {
   public static final String AppID = "wxab8a4466ceff329d";
   public static final String AppSecret = "c8a3b4ed3f1b3fa71428782e1f7b98ce";
    //通过code获取sessionKey地址
    public static final String url = "https://api.weixin.qq.com/sns/jscode2session?appid=%s&secret=%s&js_code=%s&grant_type=authorization_code";
}
