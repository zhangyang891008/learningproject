package com.spring.test.u5.demo01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class Boss {

    @Autowired(required = false)
    private Bike bike;

    @Autowired
    private Cup cup;

    public void introduce(){
        System.out.println(this.getClass().toString());
    }
}
