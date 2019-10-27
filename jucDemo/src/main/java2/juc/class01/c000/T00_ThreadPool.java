package juc.class01.c000;

import java.util.concurrent.*;

/**
 * 守护线程重要例子***
 */
public class T00_ThreadPool {


    private final static ExecutorService POOL = new ThreadPoolExecutor(1, 1, 30, TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(10), new ThreadFactory() {
        @Override
        public Thread newThread(Runnable r) {
            Thread thread = new Thread(r);
            //***如果设置成true,工作线程退出以后，立刻停止
            thread.setDaemon(true);
            thread.setName("thread" + r.hashCode());
            return thread;
        }
    }, new RejectedExecutionHandler() {
        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            System.out.println("reject"+r.hashCode());
        }
    });

    public static void main(String[] args) {
        POOL.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("mglssb");
            }
        });
    }
}
