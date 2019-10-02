package com.juc.comsumer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ComsumerTest<T> {

    LinkedList<T> list = new LinkedList<>();
    private int Max = 10;
    private int count = 0;


    public synchronized void produce(T t){

            while(count >= Max){
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            list.add(t);
            count++;
            this.notifyAll();

    }

    public synchronized T consumer(){
            while(count <= 0){
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        T remove = list.remove();
        System.out.println("consumer"+(String)remove);
        count--;
            this.notifyAll();
        return remove;
    }

    public static void main(String[] args) {
        ComsumerTest t = new ComsumerTest();
        List<Thread> consumerThreads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            consumerThreads.add(new Thread(new Runnable() {
                @Override
                public void run() {
                    while(true){
                        System.out.println(t.consumer());

                    }
                }
            }));
        }


        List<Thread> produceThreads = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            produceThreads.add(new Thread(new Runnable() {
                @Override
                public void run() {
                    int count = 1;
                    while(true){
                        t.produce(Thread.currentThread().getName()+count);
                        try {
                            TimeUnit.SECONDS.sleep(1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        count++;
                    }
                }
            }));
        }

        for (Thread consumerThread : consumerThreads) {
            consumerThread.start();
        }

        for (Thread produceThread : produceThreads) {
            produceThread.start();
        }
    }
}
