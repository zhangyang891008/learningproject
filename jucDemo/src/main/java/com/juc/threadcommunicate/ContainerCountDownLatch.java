package com.juc.threadcommunicate;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
/*
两个门闩可以保证在不sleep的情况下，先打印接受到的通知，然后工作线程再继续添加
 */

public class ContainerCountDownLatch {

    private List<String> elems = new ArrayList<>();

    void add(String value){
        elems.add(value);
    }

    int size(){
        return elems.size();
    }

    public static void main(String[] args) {
        ContainerCountDownLatch c = new ContainerCountDownLatch();

        CountDownLatch countDownLatch = new CountDownLatch(1);

        Thread operateThread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    c.add(""+i);
                    if(c.size() == 5)
                    countDownLatch.countDown();
                    System.out.println("add " +i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }


                }

            }
        });
        Thread monitorThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    countDownLatch.await();
                    System.out.println("count:5");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        monitorThread.start();
        operateThread.start();
        System.out.println("hello");
        while(true){

        }
    }
}
