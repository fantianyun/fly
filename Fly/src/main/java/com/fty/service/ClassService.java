package com.fty.service;

import com.fty.jooq.domain.tables.MallClass;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Map;

@Component
public class ClassService {
    private DSLContext dsl;
    @Autowired
    public ClassService(DSLContext dsl) {
        this.dsl = dsl;
    }
    /**
     * FTY 获取分类数据
     * @return
     */
    public  List<Map<String, Object>> getClassData() {
            MallClass C = MallClass.MALL_CLASS;
            //Result<Record3<Integer, String, String>> list = dsl.select(c.CLASS_ID,c.CLASS_IMG_URL,c.CLASS_NAME).from(c).orderBy(c.SORT).fetch();
            List<Map<String, Object>> aaa = dsl.select(C.CLASS_ID, C.CLASS_NAME, C.IMG_URL).from(C).fetchMaps();
        return aaa;
        }

}
