package com.lottery.entity;

import java.sql.Timestamp;
import java.util.Date;

public class TvSeries {
    private Integer id;
    private String name;
    private String password;
    private Date date;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TvSeries(Integer id, String name, String password, Timestamp timestamp) {
        this.name = name;
        this.id = id;
        this.password = password;
        this.date = timestamp==null?null:new Date(timestamp.getTime());
    }


    @Override
    public String toString() {
        StringBuffer buf = new StringBuffer();
        buf.append(this.getClass().getName());
        buf.append(",name:").append(name);
        return buf.toString();
    }


}
