package com.juc.volatile2;

import java.util.concurrent.TimeUnit;
//volatile 引用类型（包括数组）只能保证引用本身的可见性，不能保证内部字段的可见性
public class VolatileTest03 {

    boolean running = true;

    volatile static VolatileTest03 T = new VolatileTest03();

    void m() {
        System.out.println("m start");
        while(running) {

			try {
				TimeUnit.MILLISECONDS.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
        }
        System.out.println("m end!");
    }

    public static void main(String[] args) {
        new Thread(T::m, "t1").start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        T.running = false;
    }
}
