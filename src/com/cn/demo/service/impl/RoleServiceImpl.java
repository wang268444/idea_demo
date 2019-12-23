package com.cn.demo.service.impl;

import com.cn.demo.entity.Role;
import com.cn.demo.mapper.RoleMapper;
import com.cn.demo.service.RoleService;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    /**
     * 查询所有角色信息 转成Json格式
     *
     * @return
     */
    @Override
    public String queryRole() {
        return JSONArray.fromObject(roleMapper.queryRole()).toString();
    }

    /**
     * 角色添加
     *
     * @param role
     * @return
     */
    @Override
    public int addRole(Role role) {
        return roleMapper.addRole(role);
    }

    /**
     * 角色修改
     *
     * @param role
     * @return
     */
    @Override
    public int updateRole(Role role) {
        return roleMapper.updateRole(role);
    }

    /**
     * 角色删除
     *
     * @param roleId
     * @return
     */
    @Override
    public int deleteRole(String roleId) {
        return roleMapper.deleteRole(Integer.parseInt(roleId));
    }
}
