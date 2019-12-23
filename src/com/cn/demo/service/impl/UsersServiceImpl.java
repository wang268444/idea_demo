package com.cn.demo.service.impl;

import com.cn.demo.entity.Users;
import com.cn.demo.mapper.UsersMapper;
import com.cn.demo.service.UsersService;
import com.cn.publics.ReturnConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersMapper usersMapper;

    /**
     * 判断用户登录
     *
     * @param users
     * @return
     */
    @Override
    public String Login(Users users, HttpSession session) {
        if (usersMapper.checkUserName(users.getUserName()) == 0) {
            return ReturnConstants.RETURN_1;
        } else {
            if (users.getPassWord().equals(usersMapper.checkPassWordByUserName(users.getUserName()))) {
                session.setAttribute("loginUser", usersMapper.queryLoginUser(users));
                return ReturnConstants.RETURN_SUCCESS;
            } else {
                return ReturnConstants.RETURN_2;
            }
        }
    }
}
