package com.chapter04.annotation01;

import org.springframework.stereotype.Component;

@Component
public class Performance implements IPerformance {

    public void perform() {
        System.out.println("performing...");
    }
}
