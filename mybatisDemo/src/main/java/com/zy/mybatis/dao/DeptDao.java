package com.zy.mybatis.dao;

import com.zy.mybatis.entity.Dept;

public interface DeptDao {

    Dept loadById(Integer deptId);

    void insert(Dept dept);
}
