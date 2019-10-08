package newjuc.juc20_interview;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class L08_Semaphore {

    static List<String> list = new ArrayList<>();


    public static void main(String[] args) {
        Semaphore s = new Semaphore(5);

        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            threads.add(new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        s.acquire();
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    list.add("add"+Thread.currentThread());
                    System.out.println("add"+Thread.currentThread());
                    s.release();
                }
            }));
        }

        for (Thread thread : threads) {
            thread.start();
        }

    }
}
