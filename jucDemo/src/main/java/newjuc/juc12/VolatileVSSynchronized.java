package newjuc.juc12;

import java.util.ArrayList;
import java.util.List;

public class VolatileVSSynchronized {

    int count = 0;
    public synchronized void add(){
        for (int i = 0; i < 1000; i++) {
            count++;
        }
    }


    public static void main(String[] args) {
        VolatileVSSynchronized v = new VolatileVSSynchronized();
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            threads.add(new Thread(new Runnable() {
                @Override
                public void run() {
                    v.add();
                }
            }));
        }
        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("total count: "+v.count);
    }
}
