package com.juc.comsumer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest<T> {
    LinkedList<T> list = new LinkedList<>();
    int max = 10;
    int count = 0;
    ReentrantLock lock = new ReentrantLock();
    Condition consumer = lock.newCondition();
    Condition produce = lock.newCondition();


    public void produce(T t){
        try{
            lock.lock();
            while(list.size() >= max){
                produce.await();
            }
            list.add(t);
            count++;
            consumer.signalAll();
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }

    public T consumer(){
        try{
            lock.lock();
            while(list.size() <= 0){
                try {
                    consumer.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            T remove = list.remove();
            count--;
            produce.signalAll();
            return remove;
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
//finally里不能写return
        }

        return null;
    }

    public static void main(String[] args) {
        ReentrantLockTest<Object> t = new ReentrantLockTest<>();
        List<Thread> consumerThreads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            consumerThreads.add(new Thread(new Runnable() {
                @Override
                public void run() {
                    while(true){
                        System.out.println(t.consumer());

                    }
                }
            }));
        }


        List<Thread> produceThreads = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            produceThreads.add(new Thread(new Runnable() {
                @Override
                public void run() {
                    int count = 1;
                    while(true){
                        t.produce(Thread.currentThread().getName()+count);
                        try {
                            TimeUnit.SECONDS.sleep(1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        count++;
                    }
                }
            }));
        }

        for (Thread consumerThread : consumerThreads) {
            consumerThread.start();
        }

        for (Thread produceThread : produceThreads) {
            produceThread.start();
        }
    }
}
