package com.chapter04.annotation;

import org.springframework.stereotype.Component;

@Component
public class Performance  {

    public void perform() {
        System.out.println("performing...");
    }
}
