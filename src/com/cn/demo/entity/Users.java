package com.cn.demo.entity;

import java.sql.Timestamp;

/**
 * 创建表Users 实体类
 */
public class Users {
    private int userId;// int primary key auto_increment 用户Id
    private String userName;// varchar(50) 用户名
    private String passWord;// varchar(50) 密码
    private Timestamp create_Time;// timestamp 创建时间
    private Timestamp update_Time;// timestamp 修改时间

    public Users() {
    }

    public Users(int userId, String userName, String passWord, Timestamp create_Time, Timestamp update_Time) {
        this.userId = userId;
        this.userName = userName;
        this.passWord = passWord;
        this.create_Time = create_Time;
        this.update_Time = update_Time;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public Timestamp getCreate_Time() {
        return create_Time;
    }

    public void setCreate_Time(Timestamp create_Time) {
        this.create_Time = create_Time;
    }

    public Timestamp getUpdate_Time() {
        return update_Time;
    }

    public void setUpdate_Time(Timestamp update_Time) {
        this.update_Time = update_Time;
    }

    @Override
    public String toString() {
        return "Users{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", create_Time=" + create_Time +
                ", update_Time=" + update_Time +
                '}';
    }
}
