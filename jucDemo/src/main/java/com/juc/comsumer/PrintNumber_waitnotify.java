package com.juc.comsumer;

public class PrintNumber_waitnotify {

    public static void main(String[] args) {
        //System.out.println((char)('A'+1));

        Object o = new Object();

        Thread numberThread = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (o){
                    for (int i = 0; i < 26; i++) {
                        System.out.print((char)('A'+i));
                        o.notify();
                        try {
                            o.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }

            }
        });

        Thread shuziThread = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (o){
                    for (int i = 1; i < 27; i++) {
                        try {
                            o.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.print(i);
                        o.notify();
                    }
                }

            }
        });
        shuziThread.start();
        numberThread.start();


    }
}
