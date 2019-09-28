package com.juc.volatile2;

import java.util.concurrent.locks.Lock;

/**
 * 非静态方法上的锁是对象锁,静态方法上的锁是类锁
 * 如果一个方法是对象锁，一个是行锁呢？锁的对象不同
 */
public class LockObject {

    /*static*/ synchronized void m1(){
        System.out.println("m1 running....");
        while(true){

        }
    }

    /*static*/ synchronized void m2(){
        System.out.println("m2 running....");
        while(true){

        }
    }

    public static void main(String[] args) {
        LockObject l = new LockObject();
        LockObject ll = new LockObject();
        new Thread(new Runnable() {
            @Override
            public void run() {
                l.m1();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                ll.m2();
            }
        }).start();
    }
}
