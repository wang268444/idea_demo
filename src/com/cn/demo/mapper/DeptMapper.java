package com.cn.demo.mapper;

import com.cn.demo.entity.Dept;

import java.util.List;

public interface DeptMapper {

    /**
     * 查询所有部门信息
     *
     * @return
     */
    List<Dept> queryDept();
}
