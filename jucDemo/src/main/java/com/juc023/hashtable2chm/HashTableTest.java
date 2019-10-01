package com.juc023.hashtable2chm;

import java.util.Hashtable;
import java.util.List;
import java.util.UUID;

public class HashTableTest {
    static Hashtable<UUID, UUID> m = new Hashtable<>();
    static UUID[] keys = new UUID[Consts.COUNT];
    static UUID[] values = new UUID[Consts.COUNT];


    static {
        for (int i = 0; i < Consts.COUNT; i++) {
            keys[i] = UUID.randomUUID();
            values[i] = UUID.randomUUID();
        }
    }

    static class WorkThread extends Thread{
        int start;
        int internal = Consts.COUNT/Consts.THREAD;

        public WorkThread(int start){
            this.start = start;
        }

        @Override
        public void run() {
            for (int i = start; i < start+ internal; i++) {
                m.put(keys[i], values[i]);
                System.out.println("put :" + i );
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {

        Thread[] threads = new Thread[Consts.THREAD];
        for (int i = 0; i < Consts.THREAD; i++) {
            threads[i] = new WorkThread((Consts.COUNT/Consts.THREAD) * i);
        }
        long start = System.currentTimeMillis();
        for (int i = 0; i < Consts.THREAD; i++) {
            threads[i].start();
        }

        for (int i = 0; i < Consts.THREAD; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        long end = System.currentTimeMillis();
        //System.out.println("cost :" +(end - start));
        System.out.println("vector");
        //*****读******************************************************
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(()->{
                for (int j = 0; j < 10000000; j++) {
                    m.get(keys[20]);
                }
            });

        }

        long start2 = System.currentTimeMillis();
        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
        long end2 = System.currentTimeMillis();
        System.out.println("Cost:" +(end2 - start2));
    }
}
