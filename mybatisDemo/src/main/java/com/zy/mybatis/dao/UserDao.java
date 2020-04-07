package com.zy.mybatis.dao;

import com.zy.mybatis.entity.User;

import java.util.List;

public interface UserDao {

    User selectById(Integer userId);

    void insert(User user);

    List<User> loadAll();
}
