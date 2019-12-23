package com.cn.demo.controller;

import com.cn.demo.service.DeptService;
import com.cn.publics.JumpViewConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DeptController {

    @Autowired
    private DeptService deptService;

    /**
     * 跳转部门管理页面
     *
     * @return
     */
    @RequestMapping("/toDept.do")
    public String toDept() {
        return JumpViewConstants.TO_DEPT;
    }

    /**
     * 显示部门管理所有信息
     *
     * @return
     */
    @RequestMapping("/queryDept.do")
    public @ResponseBody
    String queryDept() {
        return deptService.queryDept();
    }
}
