package newjuc.juc20;

import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock提供了支持中断的获取锁的方法lockInterruptibly(),可以在加锁阻塞的时候响应中断
 *
 */
public class ReentrantLock04 {
    public static void main(String[] args) {

        ReentrantLock lock = new ReentrantLock();


        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    lock.lock();
                    System.out.println("thread1 entered");
                    Thread.sleep(5000);
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                    System.out.println("thread1 leaved");
                }

            }
        });
        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("t2 try to get lock");
                    lock.lockInterruptibly();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    if(lock.isHeldByCurrentThread())
                        lock.unlock();
                }
            }
        });
        t2.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                t2.interrupt();
            }
        }).start();

    }
}
