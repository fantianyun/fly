package com.fty;


import com.fty.jooq.codegen.tables.MallAd;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Record1;
import org.jooq.Result;
import org.jooq.types.UInteger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AppTest {
    @Autowired
    private DSLContext dsl;


    @Test
    public void test(){
//        MallAd m = MallAd.MALL_AD;
//        Record record = dsl.select().from(m).where(m.AD_ID.eq(UInteger.valueOf(1))).fetchOne();
//        Result record1 = dsl.select(m.AD_ID).from(m).where(m.AD_ID.eq(UInteger.valueOf(1))).fetch();
//        String url = record.get(m.IMAGE_URL);
//        System.out.println(record1);

        Result result = dsl.fetch("select * from mall_ad");
        System.out.println(result);

    }
}
