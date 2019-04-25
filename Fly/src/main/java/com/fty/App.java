package com.fty;


import com.fty.service.mybatisInterface.MybatisUserDao;
import org.apache.ibatis.cache.TransactionalCacheManager;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.io.Console;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class,args);
    }
//    @Autowired
//    SqlSessionFactory sqlSessionFactory = null;
//    @Bean
//    public MapperFactoryBean<MybatisUserDao> initMyBatisUserDao(){
//           MapperFactoryBean<MybatisUserDao> bean = new MapperFactoryBean<>();
//       bean.setMapperInterface(MybatisUserDao.class);
//        bean.setSqlSessionFactory(sqlSessionFactory);
//        System.out.println(sqlSessionFactory.getConfiguration().getDatabaseId());
//        return bean;
    //}
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer(){
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        mapperScannerConfigurer.setBasePackage("com.fty.*");
        mapperScannerConfigurer.setAnnotationClass(Repository.class);
        return  mapperScannerConfigurer;
    }
    @Autowired
    PlatformTransactionManager platformTransactionManager = null;
    @PostConstruct
    public  void  viewTransactionManager(){
        System.out.println("1111111111111111111111111111111111111111111");
        System.out.println(platformTransactionManager.getClass().getName());
    }
    @Autowired
    private RedisTemplate redisTemplate = null;
    @PostConstruct
    public  void  init(){
        initRedisTemplate();
    }
    public void initRedisTemplate(){
        RedisSerializer stringRedisSerializer = redisTemplate.getStringSerializer();
        redisTemplate.setKeySerializer(stringRedisSerializer);
        redisTemplate.setHashKeySerializer(stringRedisSerializer);
    }


}
