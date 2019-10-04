package newjuc.juc00;

public class WhatIsThread {

    public static void main(String[] args) {
        Thread t = new MyThread();
        t.start();

        Thread t2 = new Thread(new MyRunnable());
        t2.start();
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getState());
        System.out.println(this.getState());
        System.out.println("my thread is running...");
    }
}

class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("my Runnable is running...");
    }
}