package com.juc023.hashtable2chm;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class SynchronizedHashMapTest {

    //static Hashtable<UUID, UUID> m = new Hashtable<>();
    static Map<UUID, UUID> m = Collections.synchronizedMap(new HashMap<>());
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
            threads[i] = new HashTableTest.WorkThread((Consts.COUNT/Consts.THREAD) * i);
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
        System.out.println("Sychronized!");

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