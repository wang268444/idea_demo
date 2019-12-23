package com.cn.demo.entity;

import java.sql.Timestamp;

/**
 * 创建表Dept 实体类
 */
public class Dept {
    private int deptId;// int primary key auto_increment,
    private int deptParaId;// int,
    private String deptName;// varchar(50),
    private Timestamp create_Time;// timestamp,
    private Timestamp update_Time;// timestamp

    public Dept() {
    }

    public Dept(int deptId, int deptParaId, String deptName, Timestamp create_Time, Timestamp update_Time) {
        this.deptId = deptId;
        this.deptParaId = deptParaId;
        this.deptName = deptName;
        this.create_Time = create_Time;
        this.update_Time = update_Time;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public int getDeptParaId() {
        return deptParaId;
    }

    public void setDeptParaId(int deptParaId) {
        this.deptParaId = deptParaId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
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
        return "Dept{" +
                "deptId=" + deptId +
                ", deptParaId=" + deptParaId +
                ", deptName='" + deptName + '\'' +
                ", create_Time=" + create_Time +
                ", update_Time=" + update_Time +
                '}';
    }
}
