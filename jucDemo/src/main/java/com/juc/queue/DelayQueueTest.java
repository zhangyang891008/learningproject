package com.juc.queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayQueueTest {

    static BlockingQueue<MyTask> queue = new DelayQueue();

    public static void main(String[] args) {
        try {
            queue.put(new MyTask("task1",System.currentTimeMillis()+2000) );
            queue.put(new MyTask("task2",System.currentTimeMillis()+500));
            System.out.println("add...");
            System.out.println(queue.take().name);
            System.out.println("take...");
            System.out.println(queue.take().name);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

class MyTask implements Delayed {

    String name;
    long delayTime;

    public MyTask(String name, long delayTime){
        this.name = name;
        this.delayTime = delayTime;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        System.out.println("taskname:" + name + " , delayTime:" + delayTime);
        return delayTime;
    }

    @Override
    public int compareTo(Delayed o) {
        System.out.println("compareTo");
        return (delayTime - o.getDelay(TimeUnit.MILLISECONDS))>0? 1:-1;
    }
}