package com.juc.threadcommunicate;

import java.util.ArrayList;
import java.util.List;

public class ContainerWaitNotify {

    private List<String> elems = new ArrayList<>();

    void add(String value){
        elems.add(value);
    }

    int size(){
        return elems.size();
    }

    public static void main(String[] args) {
        ContainerWaitNotify c = new ContainerWaitNotify();
        Object o = new Object();
        Thread operateThread = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (o){
                    for (int i = 0; i < 10; i++) {
                        if(c.size() == 5) {
                            o.notify();
                            System.out.println("notify....");
                            break;
                        }
                        c.add("elements");
                        System.out.println("add ..." + i);
                    }
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        Thread monitorThread = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (o){
                    try {
                        o.wait();
                        System.out.println("wait over:" + c.size());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        monitorThread.start();
        operateThread.start();
    }
}
