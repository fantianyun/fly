package com.fty.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import redis.clients.jedis.JedisPoolConfig;

//@Configuration
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
       connectionFactory.setHostName("apptest.pzfresh.com");
       connectionFactory.setPort(61857);
       connectionFactory.setPassword("Pzfresh2019");
       this.connectionFactory = connectionFactory;
       return  connectionFactory;
   }
   @Bean(name = "redisTemplate")
    public RedisTemplate<Object,Object> initRedisTemplate(){
       RedisTemplate<Object,Object> redisTemplate = new RedisTemplate<>();
       RedisSerializer stringRedisSerializer = redisTemplate.getStringSerializer();
       redisTemplate.setKeySerializer(stringRedisSerializer);
       redisTemplate.setHashKeySerializer(stringRedisSerializer);
       redisTemplate.setHashValueSerializer(stringRedisSerializer);
       redisTemplate.setConnectionFactory(initRedisConnectionFactory());
       return redisTemplate;
   }
   @Bean
   public JedisConnectionFactory redisConnectionFactory() {

      RedisStandaloneConfiguration config = new RedisStandaloneConfiguration("server", 6379);
      config.setPassword("1334");
      return new JedisConnectionFactory(config);
   }
}
