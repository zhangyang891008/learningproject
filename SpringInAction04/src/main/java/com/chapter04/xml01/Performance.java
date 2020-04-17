package com.chapter04.xml01;

import org.springframework.stereotype.Component;

@Component
public class Performance implements IPerformance {

    public void perform() {
        System.out.println("performing...");
    }
}
