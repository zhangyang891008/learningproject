package com.mq.controller;

import com.mq.service.ActiveMQService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ActiveMQController {

    @Autowired
    ActiveMQService activeMQService;

    @GetMapping("send")
    public String send(){
        activeMQService.send("spring-boot", "hello");
        return "ok";
    }

}
