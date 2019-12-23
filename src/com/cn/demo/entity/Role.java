package com.cn.demo.entity;

import java.sql.Timestamp;

/**
 * 创建表Role 实体类
 */
public class Role {
    private int roleId;// int primary key auto_increment,
    private String roleName;// varchar(50),
    private int deptId;// int,
    private Timestamp create_Time;// timestamp,
    private Timestamp update_Time;// timestamp
    private String deptName;// varchar(50), 部门名称显示

    public Role() {
    }

    public Role(int roleId, String roleName, int deptId, Timestamp create_Time, Timestamp update_Time, String deptName) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.deptId = deptId;
        this.create_Time = create_Time;
        this.update_Time = update_Time;
        this.deptName = deptName;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
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

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                ", deptId=" + deptId +
                ", create_Time=" + create_Time +
                ", update_Time=" + update_Time +
                ", deptName='" + deptName + '\'' +
                '}';
    }
}
