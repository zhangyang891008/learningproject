package com.chapter04.xmlconfig;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;


public class Audience {

    public void silenceCellPhones(){
        System.out.println("silencing cell phones");
    }


    public void takeSeats(){
        System.out.println("taking seats.");
    }


    public void applause(){
        System.out.println("clap clap clap");
    }


    public void demandRefund(){
        System.out.println("Demanding a refund.");
    }
}
