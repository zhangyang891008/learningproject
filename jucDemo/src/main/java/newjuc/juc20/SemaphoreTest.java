package newjuc.juc20;

import java.util.concurrent.Semaphore;

/**
 * semaphore:初始化定义了信号量的数量，如果有剩余信号量，线程可以申请到，没有则阻塞，执行结束需要释放。
 * 信号量可以申请多个，可以支持非阻塞的申请和带有超时时间的申请。
 */
public class SemaphoreTest {

    public static Semaphore sema = new Semaphore(5);

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        sema.acquire(2);
                        System.out.println(Thread.currentThread()+" start!");
                        Thread.sleep(3000);
                        System.out.println(Thread.currentThread()+" end!");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {
                        sema.release(2);
                    }
                }
            }).start();
        }
    }
}
