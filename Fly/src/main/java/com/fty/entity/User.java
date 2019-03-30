package com.fty.entity;

import com.fty.converter.SexConverter;
import com.fty.enumeration.SexEnum;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "t_user")
@Entity(name = "User")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name")
    private String userName;

    @Convert(converter = SexConverter.class)
    private SexEnum Sex;
    @Column(name = "note")
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
