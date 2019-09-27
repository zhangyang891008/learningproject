package com.juc.volatile2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 自增操作：多线程并发的对一个变量增减, volatile只具有可见性，不能保证操作的原子性和数据的一致性
 *
 */
public class VolatileTest04 {
    //int count = 0;
    volatile int count = 0;

    void add(){
        for (int i = 0; i < 1000; i++) {
            count ++;
        }
    }

    public static void main(String[] args) {
        VolatileTest04 t = new VolatileTest04();
        List<Thread> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add(new Thread(new Runnable() {
                @Override
                public void run() {
                    t.add();
                }
            }));
        }
        for (Thread thread: list
             ) {
            thread.start();
        }
        list.forEach(th-> {
            try {
                th.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println("finished..." + t.count);
    }
}
