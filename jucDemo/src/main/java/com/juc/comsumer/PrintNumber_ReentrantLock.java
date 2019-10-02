package com.juc.comsumer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class PrintNumber_ReentrantLock {

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Condition print = lock.newCondition();

        Thread numberThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    lock.lock();
                    for (int i = 0; i < 26; i++) {
                        System.out.print((char)('A'+i));
                        print.signal();
                        print.await();
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }finally{
                    lock.unlock();
                }
            }
        });

        Thread shuziThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    lock.lock();
                    for (int i = 1; i < 27; i++) {
                        print.await();
                        System.out.print(i);
                        print.signal();
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }finally{
                    lock.unlock();
                }
            }
        });

        shuziThread.start();
        numberThread.start();

    }
}
