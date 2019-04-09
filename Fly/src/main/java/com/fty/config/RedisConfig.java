package com.fty.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class RedisConfig {
   private RedisConnectionFactory connectionFactory = null;
   @Bean(name = "RedisConnectionFactory")
    public  RedisConnectionFactory initRedisConnectionFactory(){
       if(this.connectionFactory !=null){
           return connectionFactory;
       }
       JedisPoolConfig poolConfig = new JedisPoolConfig();
       poolConfig.setMaxIdle(30);
       poolConfig.setMaxTotal(50);
       poolConfig.setMaxWaitMillis(2000);
       //传教Jedis连接工厂
       JedisConnectionFactory connectionFactory = new JedisConnectionFactory(poolConfig);
       //获取单机的Redis配置
       RedisStandaloneConfiguration rsConfig = connectionFactory.getStandaloneConfiguration();
       connectionFactory.setHostName("192.168.1.111");
       connectionFactory.setPort(66689);
       connectionFactory.setPassword("123456");
       this.connectionFactory = connectionFactory;
       return  connectionFactory;
   }
   @Bean(name = "redisTemplate")
    public RedisTemplate<Object,Object> initRedisTemplate(){
       RedisTemplate<Object,Object> redisTemplate = new RedisTemplate<>();
       redisTemplate.setConnectionFactory(initRedisConnectionFactory());
       return redisTemplate;
   }

}
