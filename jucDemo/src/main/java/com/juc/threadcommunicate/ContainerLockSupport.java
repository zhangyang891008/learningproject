package com.juc.threadcommunicate;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.LockSupport;
/*
两个门闩可以保证在不sleep的情况下，先打印接受到的通知，然后工作线程再继续添加
 */

public class ContainerLockSupport {

    private List<String> elems = new ArrayList<>();

    void add(String value){
        elems.add(value);
    }

    int size(){
        return elems.size();
    }

    public static void main(String[] args) {
        ContainerLockSupport c = new ContainerLockSupport();

        Thread monitorThread = new Thread();
        Thread operateThread = new Thread();
        operateThread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    c.add(""+i);
                    if(c.size() == 5)
                       // LockSupport.unpark(monitorThread);
                        LockSupport.park();
                    System.out.println("add " +i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }


                }

            }
        });
        monitorThread = new Thread(new Runnable() {
            @Override
            public void run() {

                LockSupport.park();
                System.out.println("count:5");
            }
        });

        monitorThread.start();
        operateThread.start();
        System.out.println("hello");
        while(true){

        }
    }
}
