package com.cn.demo.mapper;

import com.cn.demo.entity.Role;

import java.util.List;

public interface RoleMapper {

    /**
     * 查询所有角色信息
     *
     * @return
     */
    List<Role> queryRole();

    /**
     * 添加角色信息
     *
     * @param role
     * @return
     */
    int addRole(Role role);

    /**
     * 修改角色信息
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
    int deleteRole(int roleId);
}
