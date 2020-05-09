package com.testspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@Component
public class MailService {
    @Autowired
    UserService userService;

    public void sandMail(){
        System.out.println("sendMail starting...");

        //ZoneId zoneId = userService.zoneId; //引用属性字段
        ZoneId zoneId = userService.getFinalZoneId(); //调用final方法
        //ZoneId zoneId = userService.getZoneId();  //调用public方法

        System.out.println(zoneId);
    }

}
