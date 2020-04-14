package com.forum.controller;

import com.forum.dao.UserDao;
import com.forum.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @Autowired
    private UserDao userDao;

    @RequestMapping("/user")
    public String saveUser(){
        userDao.save(new User());
        return "success";
    }
}
