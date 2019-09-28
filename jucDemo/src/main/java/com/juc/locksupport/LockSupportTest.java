package com.juc.locksupport;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * LockSupport: 可以唤醒指定的线程，并且不需要加锁。 Synchornized叫醒某个特定线程比较困难
 *
 *
 */
public class LockSupportTest {
    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("--" + i);
                    if(i==5|| i== 8){
                        System.out.println("parking ...");
                        LockSupport.park();
                    }
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        t.start();
        try {
            Thread.sleep(1000);
            LockSupport.unpark(t);
            Thread.sleep(9000);
            LockSupport.unpark(t);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
