package com.cn.demo.mapper;

import com.cn.demo.entity.Users;

public interface UsersMapper {

    /**
     * 查询登录时用户名是否存在
     *
     * @param userName
     * @return
     */
    int checkUserName(String userName);

    /**
     * 查询登录时密码是否正确
     *
     * @param userName
     * @return
     */
    String checkPassWordByUserName(String userName);

    /**
     * 获取登录用户得所有信息
     *
     * @param users
     * @return
     */
    Users queryLoginUser(Users users);
}
