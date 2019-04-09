package com.fty.entity;

import com.fty.enumeration.SexEnum;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;
@Alias(value = "user")
public class User implements Serializable {

    private Long id;

    private String userName;

    private SexEnum Sex;

    private String note;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public SexEnum getSex() {
        return Sex;
    }

    public void setSex(SexEnum sex) {
        Sex = sex;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
