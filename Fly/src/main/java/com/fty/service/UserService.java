package com.fty.service;

import com.alibaba.fastjson.JSONObject;
import com.fty.config.WxConfig;
import com.fty.jooq.domain.tables.MallUser;
import org.apache.http.client.fluent.Request;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
public class UserService {
    private DSLContext dsl ;
    @Autowired
    public UserService(DSLContext dsl){
        this.dsl = dsl;
    }

    public Map<String, Object>  code2session(String code) {
        String request;
        Map<String, Object> map = new HashMap<>();
        try {
            request = Request.Get(String.format(WxConfig.url, WxConfig.AppID, WxConfig.AppSecret, code)).execute().returnContent().asString();
            JSONObject requestResultJson = JSONObject.parseObject(request);
            System.out.println(requestResultJson);
            if(!requestResultJson.containsKey("errcode")){
                String openID = requestResultJson.getString("openid");
                String sessionKey = requestResultJson.getString("session_key");
                MallUser user = MallUser.MALL_USER;
                Record re = dsl.select().from(user).where(user.OPEN_ID.eq(openID)).fetchOne();
                //第一次登录保存用户数据
                if (re == null) {
                    dsl.insertInto(user, user.OPEN_ID, user.SESSION_KEY).values(openID, sessionKey).execute();
                }
                map.put("code", 1);
                map.put("openID", openID);
                map.put("session_key", sessionKey);
            }else{
                map.put("code",requestResultJson.getIntValue("errcode"));
                map.put("errMsg",requestResultJson.getString("errmsg"));
            }
        } catch (IOException e) {
            e.printStackTrace();

        }
        return map;
    }
}
