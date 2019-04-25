package com.fty.entity;

import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.util.Date;

public class Validator {
    @NotNull(message = "ID不能为空")
    private  long id;

    @Future(message = "需要一个将来的日期")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull
    private Date date;


    @DecimalMin(value = "0.1")
    @DecimalMax(value = "1000")
    private  Double doubleValue;


    @Min(value = 1)
    @Max(value = 1000)
    private  Integer integer;
    @Range(min = 1,max = 1000)
    private Long range;

    @NotNull
    @Email(message = "邮箱格式不正确")
    private String email;

    @Size(min = 20,max = 30,message = "字符串的长度要求是20到30")
    private String size;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getDoubleValue() {
        return doubleValue;
    }

    public void setDoubleValue(Double doubleValue) {
        this.doubleValue = doubleValue;
    }

    public Integer getInteger() {
        return integer;
    }

    public void setInteger(Integer integer) {
        this.integer = integer;
    }

    public Long getRange() {
        return range;
    }

    public void setRange(Long range) {
        this.range = range;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
