package com.forum.controller;

import com.forum.domain.User;
import com.forum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/register")
    public String register(@RequestParam("username")String username, @RequestParam("password")String password,Model model){
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

    @RequestMapping("/login")
    public ModelAndView login(HttpServletRequest request, String username, String password){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("success");
        User user = userService.getUserByUserName(username);
        if(user == null){
            mv.addObject("msg","user not exits");
        }else if(!user.getPassword().equals(password)){
            mv.addObject("msg","password is wrong");
        }else if(user.getLocked() == User.LOCK_USER){
            mv.addObject("msg","user is locked");
        }else {
            //TODO:还需要检查用户是否被锁定

            //设置登陆信息
            user.setLastIp(request.getRemoteAddr());
            user.setLastVisit(new Date());
            userService.loginSuccess(user);

            //TODO:设置sessionuser
            //TODO:设置登陆成功跳转地址
            //暂时改为跳转到默认页面
            mv.setViewName("success");
            mv.addObject("msg","login success");
        }
        return mv;
    }


    @RequestMapping("/listUser")
    public String loadAll(Model model){
        List<User> all = userService.loadAll();
        for (User user : all) {
            System.out.println(user);
        }
        model.addAttribute("msg","loadAll user success!");
        model.addAttribute("users",all);
        return "user/list";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable(name = "id") int id, Model model){
        userService.delete(id);
        model.addAttribute("msg","delete user success!");
        return "success";
    }
}
