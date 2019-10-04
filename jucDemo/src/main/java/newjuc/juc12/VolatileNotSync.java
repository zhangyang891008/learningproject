package newjuc.juc12;

import java.util.ArrayList;
import java.util.List;

/**
 * volatile只能保证可见性，不能保证多个线程并发修改的数据一致性，因此不能替代synchronized
 */
public class VolatileNotSync {
    volatile int count = 0;
    public void add(){
        for (int i = 0; i < 10000; i++) {
            count++;
        }
    }

    public static void main(String[] args) {
        VolatileNotSync v = new VolatileNotSync();

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

        System.out.println("total:" + v.count);
    }
}
