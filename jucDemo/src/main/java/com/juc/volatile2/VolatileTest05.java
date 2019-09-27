package com.juc.volatile2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 自增操作：多线程并发的对一个变量增减，用原子类java.util.concurrent.atomic包可以避免更新异常
 *
 */
public class VolatileTest05 {
    //int count = 0;
    //volatile int count = 0；
    public AtomicInteger count = new AtomicInteger(0);

    void add(){
        for (int i = 0; i < 1000; i++) {
            count.getAndDecrement();
        }
    }

    public static void main(String[] args) {
        VolatileTest05 t = new VolatileTest05();
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
