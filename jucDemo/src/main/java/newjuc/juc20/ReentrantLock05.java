package newjuc.juc20;


import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock可以设置公平锁
 */
public class ReentrantLock05 implements Runnable{

    ReentrantLock lock = new ReentrantLock(true);

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            lock.lock();
            try{
                //Thread.sleep(1);
                System.out.println(Thread.currentThread()+" 获得锁");
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }

    }

    public static void main(String[] args) {
        ReentrantLock05 t = new ReentrantLock05();
        Thread t1 = new Thread(t,"thread-01");
        Thread t2 = new Thread(t,"thread-02");
        t1.start();
        t2.start();
    }
}
