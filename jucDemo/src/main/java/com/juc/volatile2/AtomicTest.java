package com.juc.volatile2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Atomic*中的方法都是原子性的，但不保证多个方法连续调用是原子性的???
 *
 */
public class AtomicTest {
    AtomicInteger count = new AtomicInteger(0);

    void addTwice(){
        for (int i = 0; i < 1000; i++) {
            int ret = count.getAndIncrement();
            count.getAndSet(ret+1);
        }

    }

    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();
        AtomicTest t = new AtomicTest();
        for (int i = 0; i < 200; i++) {
            threads.add(new Thread(new Runnable() {
                @Override
                public void run() {
                    t.addTwice();
                }
            }));
        }
        threads.forEach(thread -> {
            thread.start();
        });

        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println("finish..." + t.count);
    }
}
