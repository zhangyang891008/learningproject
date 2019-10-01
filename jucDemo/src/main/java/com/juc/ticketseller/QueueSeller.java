package com.juc.ticketseller;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Queue实现的多线程售票，性能高，且没有数据一致性问题
 */
public class QueueSeller {
    static Queue<Integer> tickets = new ConcurrentLinkedQueue<>();
    static{
        for (int i = 0; i < 1000000; i++) {
            tickets.add(i);
        }
    }

    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while(true){
                        Integer poll = tickets.poll();
                        if(poll == null){
                            System.out.println(Thread.currentThread().getName()+"all tickets sold out !!!" );
                            break;
                        }
                        System.out.println(Thread.currentThread().getName() + " , ticketNum :" + poll);
                    }
                }
            }).start();
        }

    }
}
