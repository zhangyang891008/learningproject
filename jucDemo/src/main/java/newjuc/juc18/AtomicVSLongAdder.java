package newjuc.juc18;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

/**
 * 由于LongAdder分段加锁，在线程并发量非常大的情况下性能很好
 *
 */

public class AtomicVSLongAdder {
    static AtomicLong count1 = new AtomicLong(0);
    static LongAdder count2 = new LongAdder();


    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < Consts.THREAD; i++) {
            threads.add(new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < Consts.LOOP; j++) {
                        count1.getAndIncrement();
                    }
                }
            }));
        }
        long atomicStart  = System.currentTimeMillis();

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

        threads = new ArrayList<>();

        long atomicEnd = System.currentTimeMillis();
        System.out.println("atomic cost: " +(atomicEnd - atomicStart));

        for (int i = 0; i < Consts.THREAD; i++) {
            threads.add(new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < Consts.LOOP; j++) {
                        count2.increment();
                    }
                }
            }));

        }

        long adderStart = System.currentTimeMillis();
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
        long adderEnd = System.currentTimeMillis();
        System.out.println("adder cost: " + (adderEnd - adderStart));

    }

}

class Consts{
    static int THREAD = 1000;
    static int LOOP = 100000;

}