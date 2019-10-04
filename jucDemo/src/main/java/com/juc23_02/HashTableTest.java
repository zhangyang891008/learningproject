package com.juc23_02;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.UUID;

public class HashTableTest {

    static UUID[] keys = new UUID[Consts.DATA_COUNT];
    static UUID[] values = new UUID[Consts.DATA_COUNT];
    static Hashtable<UUID, UUID> map = new Hashtable<>();

    static{
        for (int i = 0; i < Consts.DATA_COUNT; i++) {
            keys[i] = UUID.randomUUID();
            values[i] = UUID.randomUUID();
        }
    }

    static class WorkThread extends Thread{

        int start = 0;
        int gap = 0;
        public WorkThread(int start, int gap){
            this.start = start;
            this.gap = gap;
        }

        @Override
        public void run() {
            for (int i = start; i < start + gap; i++) {
                map.put(keys[i], values[i]);
            }
        }
    }


    public static void main(String[] args) {

        List<Thread> putThreads = new ArrayList<>();
        for (int i = 0; i < Consts.THREAD_NUM; i++) {
            putThreads.add(new WorkThread(Consts.DATA_COUNT/Consts.THREAD_NUM * i, Consts.DATA_COUNT/Consts.THREAD_NUM));
        }

        long putStart = System.currentTimeMillis();
        for (Thread putThread : putThreads) {
            putThread.start();
        }

        for (Thread putThread : putThreads) {
            try {
                putThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        long putEnd = System.currentTimeMillis();
        System.out.println("put cost:" + (putEnd - putStart));

        List<Thread> getThreads = new ArrayList<>();
        for (int i = 0; i < Consts.THREAD_NUM; i++) {
            getThreads.add(new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 10000000; j++) {
                        map.get(10);
                    }

                }
            }));
        }

        long getStart = System.currentTimeMillis();
        for (Thread getThread : getThreads) {
            getThread.start();
        }

        for (Thread getThread : getThreads) {
            try {
                getThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        long getEnd = System.currentTimeMillis();
        System.out.println("get Cost: " + (getEnd - getStart));


    }
}
