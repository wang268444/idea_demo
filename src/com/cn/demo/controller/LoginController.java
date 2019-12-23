package com.cn.demo.controller;

import com.cn.demo.entity.Users;
import com.cn.demo.service.UsersService;
import com.cn.publics.JumpViewConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * 用户登录请求处理
 */
@Controller
public class LoginController {

    @Autowired
    private UsersService usersService;

    /**
     * 跳转登录页面
     *
     * @return
     */
    @RequestMapping("/toLogin.do")
    public String toLogin() {
        return JumpViewConstants.TO_LOGIN;
    }

    /**
     * 判断用户登录请求
     * 把登录得用户信息存入session (key:loginUser)
     *
     * @param users
     * @return
     */
    @RequestMapping("/login.do")
    public @ResponseBody
    String login(Users users, HttpSession session) {
        return usersService.Login(users, session);
    }

    /**
     * 登录成功，跳转到主页面
     *
     * @return
     */
    @RequestMapping("/toIndex.do")
    public String index() {
        return JumpViewConstants.TO_INDEX;
    }
}
