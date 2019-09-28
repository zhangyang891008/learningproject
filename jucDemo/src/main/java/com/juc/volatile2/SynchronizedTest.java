package com.juc.volatile2;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * wait notify 测试
 * 当多个线程都在等待资源进入wait状态，notify可以将其中的一个线程唤醒，notifyall可以唤醒所有等待的线程，但是多个线程需要竞争资源
 *
 */
public class SynchronizedTest {

    static Object o = new Object();
    volatile List<String> products = new ArrayList<>();

    public void consume() {
        System.out.println(Thread.currentThread().getName() + " entering comsume method...");
        synchronized (o){
            try {
                //1.判断是否有资源，没有等待
                if(products.size() == 0){
                    o.wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //2.接到notify通知
            System.out.println(Thread.currentThread().getName() + " start to consume product!");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String product = products.remove(0);
            System.out.println(Thread.currentThread().getName() + " comsume product success !" + product);
        }
    }

    public void produce(String product) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " entering produce..." );
        synchronized (o){
            Thread.sleep(5000);
            products.add(product);
            System.out.println(Thread.currentThread().getName()+ " produce product success !" + product);
            // o.notify();
            o.notifyAll();
        }
    }

    public static void main(String[] args) {
        SynchronizedTest t = new SynchronizedTest();
        List<Thread> consumeThreads = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            consumeThreads.add(new Thread(new Runnable() {
                @Override
                public void run() {
                    t.consume();
                }
            },"comsum"+i));
        }

        Thread produceThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    t.produce("myproduce");
                } catch (InterruptedException e) {
                    //e.printStackTrace();
                    System.out.println("---" + e);
                }
            }
        },"produce01");

        for (int i = 0; i < 10; i++) {
            consumeThreads.get(i).start();
        }
        produceThread.start();

        while(true){

        }

    }
}
