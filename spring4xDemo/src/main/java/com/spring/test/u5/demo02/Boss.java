package com.spring.test.u5.demo02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class Boss {

    @Autowired
    private Cup cup;

    public void introduce(){
        System.out.println(this.getClass().toString());
    }
}
