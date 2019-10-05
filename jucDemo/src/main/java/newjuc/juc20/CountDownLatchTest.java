package newjuc.juc20;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * 每个线程执行结束或者完成某项任务以后，调用countdown(),当调用countdown方法的数量达到定义CountDownLatch是传入的数量时，await()的业务可以继续执行。
 */
public class CountDownLatchTest {
    public static void main(String[] args) {
        useCountDownLatch();
        //useJoin();
    }

    public static void useCountDownLatch(){
        List<Thread>  threads = new ArrayList<>();
        CountDownLatch countDownLatch = new CountDownLatch(threads.size());

        for (int i = 0; i < 100; i++) {
            threads.add(new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread()+"--executing");
                    countDownLatch.countDown();
                }
            }));
        }

        for (Thread thread : threads) {
            thread.start();
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("countdown end");
    }

    public static void useJoin(){
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            threads.add(new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread()+"--join");

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

        System.out.println("------end");
        
    }
}
