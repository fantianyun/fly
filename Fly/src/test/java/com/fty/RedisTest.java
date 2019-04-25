package com.fty;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RedisTest {
    @Autowired
    private RedisTemplate redisTemplate = null;
    @Autowired
    private StringRedisTemplate stringRedisTemplate = null;
    @Test
    public void test(){
        redisTemplate.opsForValue().set("key1","value1");
        stringRedisTemplate.opsForValue().set("key2","3");
        String value1 = (String) redisTemplate.opsForValue().get("key1");
        System.out.println(value1);
        stringRedisTemplate.opsForValue().increment("key2",1);
        stringRedisTemplate.opsForValue().decrement("key2",2);
        System.out.println(stringRedisTemplate.opsForValue().get("key2"));
        Map<String,String> map1 = new HashMap<>();
        map1.put("a1","a1value");
        map1.put("a2","a2");
        stringRedisTemplate.opsForHash().putAll("map1",map1);
        stringRedisTemplate.opsForHash().put("map1","a3","a3");
        String a3= (String) stringRedisTemplate.opsForHash().get("map1","a3");
        stringRedisTemplate.opsForHash().values("map1");
        System.out.println(  stringRedisTemplate.opsForHash().values("map1"));


    }
    @Test
    public  void  luaTest(){
        DefaultRedisScript<String> rs = new DefaultRedisScript<>();
        rs.setScriptText("return 'hell redis'");
        rs.setResultType(String.class);
        RedisSerializer<String> redisSerializer = redisTemplate.getStringSerializer();
        String  str = (String) redisTemplate.execute(rs,redisSerializer,redisSerializer,null);
        System.out.println(str);

    }
}
