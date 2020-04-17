package com.chapter04.introduction;

import org.springframework.stereotype.Component;

@Component
public class Performance implements IPerformance{

    public void perform(){
        System.out.println("performming...");
    }
}
