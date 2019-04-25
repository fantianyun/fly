package com.fty;
import com.fty.Calzone.Builder;
import org.jooq.DSLContext;
import org.jooq.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;

import java.io.*;
import java.nio.Buffer;
import java.util.List;
import java.util.Objects;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AppTest {
    @Autowired
    private DSLContext dsl;

    public static  Boolean valueOf(Boolean b) {
        return b ? Boolean.TRUE : Boolean.FALSE;
    }
    @Test
    public void test() {
       Pizza aa = new SubPizza.Builder(SubPizza.Size.SMALL).addTopping(Pizza.Topping.HAM).addTopping(Pizza.Topping.ONION).build();
       //Calzone cz = new Calzone().Builder.toppings(Pizza.Topping.MUSHROOM).build;
        Calzone calzone = new Calzone.Builder().addTopping(Pizza.Topping.HAM).sauceInside().build();
       aa.print();
        calzone.print();
    Boolean.valueOf("aa");
    }
    @Test
    public  void   abc(){
        Long sum = 0L;
        for (long i = 0; i <= Integer.MAX_VALUE; i++)
            sum += i;
        System.out.println(sum);
    }
    public static void  copy(String src,String dst) throws IOException {
        try (
                InputStream in = new FileInputStream(src);
                FileOutputStream out1 = new FileOutputStream(dst);
        ) {
            byte[] buff = new byte[10];
            int n;
            while ((n = in.read(buff))>0)
                out1.write(buff,0,n);
        }
    }


    public final class CaseInsensitiveString {
        private final String s;
        public CaseInsensitiveString(String s) {
            this.s = Objects.requireNonNull(s);
        }
        // Broken - violates symmetry!
        //
//        public boolean equals(Object o) {
//            if (o instanceof CaseInsensitiveString)
//                return s.equalsIgnoreCase(((CaseInsensitiveString) o).s);
//            if (o instanceof String) // One-way interoperability!
//                return s.equalsIgnoreCase((String) o);
//            return false;
//        }
        @Override
        public boolean equals(Object o) {
            return o instanceof CaseInsensitiveString && ((CaseInsensitiveString) o).s.equalsIgnoreCase(s);
        }
    }
    @Test
    public void  testRedis(){
        Jedis jedis = new Jedis("apptest.pzfresh.com");
        jedis.auth("Pzfresh2019");
        String value = jedis.get("foo");
        System.out.println(value);
    }

}
