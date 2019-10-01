package com.juc023.hashtable2chm;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class HashMapTest {

    //static Hashtable<UUID, UUID> m = new Hashtable<>();
    static Map<UUID, UUID> m = new HashMap<>();
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

    public static void main(String[] args) {

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
        System.out.println("cost :" +(end - start));
        System.out.println("HashMap");
    }
}