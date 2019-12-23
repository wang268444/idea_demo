package com.cn.demo.service;

import com.cn.demo.entity.Users;

import javax.servlet.http.HttpSession;

public interface UsersService {

    /**
     * 判断用户登录
     */
    String Login(Users users, HttpSession session);
}
