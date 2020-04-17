package com.chapter04.xml01;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class Audience {

    @Around("execution(* com.chapter04.xml01.Performance.perform(..))")
    public void watchPerformance(ProceedingJoinPoint jp){
        try{
            System.out.println("around:silencing cell phones");
            System.out.println("around:taking seats");
            jp.proceed();
            System.out.println("around:clap clap...");
        }catch(Throwable e){
            System.out.println("around:demanding a refund");
        }
    }

}
