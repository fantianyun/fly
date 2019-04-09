//package com.fty;
//
//import ch.qos.logback.core.net.SyslogOutputStream;
//import com.fty.entity.User;
//import com.fty.service.jpaInterface.JpaUserRepository;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class JpaTest {
//    @Autowired
//    private JpaUserRepository jpaUserRepository;
//    @Test
//    public  void jpaTest(){
////        com.fty.entity.User  user = jpaUserRepository.findById(new Long(1)).get();
////        System.out.println("------------------数据查询开始--------------------------");
////        System.out.println(user);
//
//        jpaUserRepository.findAll().forEach(user -> {
//            System.out.println(user.getUserName() + "--->" + user.getNote());
//        });
//        Iterable<User> it = jpaUserRepository.findAll().forEach();
//
//
//        System.out.println("------------------数据查询结束--------------------------");
//
//    }
//
//
//}
