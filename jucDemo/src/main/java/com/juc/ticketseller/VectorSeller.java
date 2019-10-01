package com.juc.ticketseller;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * Vector实现的多线程售票效率比较低，且 ticket.size() ticket.remove()方法中间是非原子性的，有数据一致性问题
 */
public class VectorSeller {

    static Vector<Integer> tickets = new Vector();
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
                        if(tickets.size()>0 ){
                            Integer poll = tickets.remove(0);
                            System.out.println(Thread.currentThread().getName() + " , ticketNum :" + poll);
                            try {
                                Thread.sleep(10);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }else{
                            System.out.println(Thread.currentThread().getName()+"all tickets sold out !!!" );
                            break;
                        }

                    }
                }
            }).start();

        }

    }
}
