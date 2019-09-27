package com.juc.volatile2;

/**
 * 不要把String 作为加锁对象, s1和s2是同一把锁
 */
public class LockString {
    String s1 = "abc";
    String s2 = "abc";
    boolean running = true;

    void m1(){
        System.out.println("m1 start ...");
        synchronized (s1){
            while(running){
                //System.out.println("m1 running ...");
            }
            System.out.println("m1 start ...");
        }
    }

    void m2() {
        synchronized (s2){
            System.out.println("m2 start ...");
            while(running){
                //System.out.println("m2 running ...");
            }
            System.out.println("m2 end ...");
        }
    }

    public static void main(String[] args) {
        LockString ls = new LockString();
        new Thread(new Runnable() {
            @Override
            public void run() {
                ls.m1();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                ls.m2();
            }
        }).start();


    }

}
