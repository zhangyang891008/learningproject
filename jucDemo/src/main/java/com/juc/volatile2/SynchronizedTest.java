package com.juc.volatile2;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * wait notify 测试
 * 当多个线程都在等待资源进入wait状态，notify可以将其中的一个线程唤醒，notifyall可以唤醒所有等待的线程，但是多个线程需要竞争资源
 *
 */
public class SynchronizedTest extends  Thread {

    static Object o = new Object();

    public void run()  {
        synchronized (o){
        System.out.println(Thread.currentThread().getName() + " entering comsume method...");
            if (!Thread.currentThread().getName().contains("3")) {
                try {
                    o.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                o.notifyAll();
                try {
                    o.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //2.接到notify通知
            int i =0;
            while(i < 10){
                i++;
                System.out.println(Thread.currentThread().getName() + "****");
            }

        }
    }

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            new SynchronizedTest().start();
        }


    }
}
