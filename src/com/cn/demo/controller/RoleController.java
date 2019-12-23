package com.cn.demo.controller;

import com.cn.demo.entity.Role;
import com.cn.demo.service.RoleService;
import com.cn.publics.JumpViewConstants;
import com.cn.publics.ReturnConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RoleController {

    @Autowired
    private RoleService roleService;

    /**
     * 跳转角色管理页面
     *
     * @return
     */
    @RequestMapping("/toRole.do")
    public String toRole() {
        return JumpViewConstants.TO_ROLE;
    }

    /**
     * 显示角色管理所有信息
     *
     * @return
     */
    @RequestMapping("queryRole.do")
    public @ResponseBody
    String queryRole() {
        return roleService.queryRole();
    }

    /**
     * 角色删除
     *
     * @param roleId
     * @return
     */
    @RequestMapping("/deleteRole.do")
    public @ResponseBody
    String deleteRole(String roleId) {
        roleService.deleteRole(roleId);
        return ReturnConstants.RETURN_SUCCESS;
    }

    /**
     * 角色添加 and 修改 用roleId来区分
     *
     * @param role
     * @return
     */
    @RequestMapping("/addOrUpdateRole.do")
    public @ResponseBody
    String addOrUpdateRole(Role role) {
        if (role.getRoleId() == 0) {
            roleService.addRole(role);
            return ReturnConstants.RETURN_SUCCESS;
        } else {
            roleService.updateRole(role);
            return ReturnConstants.RETURN_SUCCESS;
        }
    }
}
