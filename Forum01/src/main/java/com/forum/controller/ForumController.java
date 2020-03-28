package com.forum.controller;

import com.forum.exception.UserNotExistException;
import com.forum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ForumController {
    @Autowired
    private UserService userService;

    @RequestMapping("/unlockUser")
    public String unlockUser(String username, Model model){
        try {
            userService.unLockUser(username);
            model.addAttribute("msg","unlock user success!");
            return "success";
        } catch (UserNotExistException e) {
            e.printStackTrace();
            model.addAttribute("msg",e.getMessage());
            return "error";
        }

    }

    @RequestMapping("/lockUser")
    public String lockUser(String username,Model model){
        try {
            userService.lockUser(username);
            model.addAttribute("msg","lock user success");
            return "success";
        } catch (UserNotExistException e) {
            e.printStackTrace();
            model.addAttribute("msg",e.getMessage());
            return "error";
        }
    }

}
