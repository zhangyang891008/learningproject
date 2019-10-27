package juc.class02.u2.volatileisnotatomic;

import java.util.ArrayList;
import java.util.List;

/*
    volatile具有可见性，但是不具有原子性
 */
public class T16_volatile {
    volatile int count = 0;
    public /*synchronized*/ void m(){

        for (int i = 0; i < 10000; i++) {
            count++;
        }
    }

    public static void main(String[] args) {
        T16_volatile t = new T16_volatile();
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            threads.add(new Thread(t::m));
        }

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(t.count);

    }
}
