package com.cn.demo.service;

import com.cn.demo.entity.Role;

public interface RoleService {

    /**
     * 查询所有角色信息
     *
     * @return
     */
    String queryRole();

    /**
     * 角色添加
     *
     * @param role
     * @return
     */
    int addRole(Role role);

    /**
     * 角色修改
     *
     * @param role
     * @return
     */
    int updateRole(Role role);

    /**
     * 角色删除
     *
     * @param roleId
     * @return
     */
    int deleteRole(String roleId);
}
