package juc.class01.c000;


/*
    线程的两种启动方式
 */
public class T01_WhatIsThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 200; i++) {
            System.out.println("thread run");
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        T01_WhatIsThread t = new T01_WhatIsThread();
        //t.run();
        t.start();
        for (int i = 0; i < 200; i++) {
            System.out.println("main run");
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
