package com.chapter04.annotation;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class Audience {

    @Before("execution(* com.chapter04.annotation.Performance.perform(..))")
    public void silenceCellPhones(){
        System.out.println("silencing cell phones");
    }

    @Before("execution(* com.chapter04.annotation.Performance.perform(..))")
    public void takeSeats(){
        System.out.println("taking seats.");
    }

    @AfterReturning("execution(* com.chapter04.annotation.Performance.perform(..))")
    public void applause(){
        System.out.println("clap clap clap");
    }

    @AfterThrowing("execution(* com.chapter04.annotation.Performance.perform(..))")
    public void demandRefund(){
        System.out.println("Demanding a refund.");
    }
}
