package com.forum.controller;

import com.forum.domain.User;
import com.forum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
public class RegistController {
    @Autowired
    private UserService userService;

    @RequestMapping("/register")
    public String register(@RequestParam("username")String username, @RequestParam("password")String password, Model model){
        User user = new User();
        user.setUserName(username);
        user.setPassword(password);
        user.setUserType(1);
        user.setLocked(0);
        user.setCredit(0);
        user.setLastIp("127.0.0.2");
        user.setLastVisit(new Date());
        userService.save(user);
        model.addAttribute("msg","save user success!");
        return "success";
    }
}
