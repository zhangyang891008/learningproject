package com.chapter04.xmlintroduction;

import org.springframework.stereotype.Component;

public class Performance implements IPerformance {

    public void perform(){
        System.out.println("performming...");
    }
}
