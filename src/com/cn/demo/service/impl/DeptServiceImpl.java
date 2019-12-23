package com.cn.demo.service.impl;

import com.cn.demo.mapper.DeptMapper;
import com.cn.demo.service.DeptService;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    /**
     * 查询所有部门信息 转成Json格式
     *
     * @return
     */
    @Override
    public String queryDept() {
        return JSONArray.fromObject(deptMapper.queryDept()).toString();
    }
}
