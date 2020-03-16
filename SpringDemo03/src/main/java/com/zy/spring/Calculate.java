package com.zy.spring;

import org.springframework.stereotype.Component;
/*
1注解方式
 */
@Component
public class Calculate {

    public void sum(int a,int b){
        System.out.println(a+b);
    }

    public void minus(int a ,int b){
        System.out.println(a-b);
    }

    public void divide(int a, int b){
        int c = 0;
        try{
            c = a/b;
        }finally {
            System.out.println(c);
        }
    }
}
