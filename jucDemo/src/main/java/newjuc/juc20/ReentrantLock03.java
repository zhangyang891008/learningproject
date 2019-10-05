package newjuc.juc20;

import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock可以通过trylock()非阻塞的申请锁，也可以通过传参数定义等待锁的时间trylock(time,timeunit),可以通过返回的状态判断是否成功的获得锁。
 * 经过测试，通过trylock返回值和lock.isHeldByCurrentHhread都可以正确的获得线程是否加锁成功的状态并且正确的解锁。
 */
public class ReentrantLock03 {

    ReentrantLock lock = new ReentrantLock();

    public void m(){
        boolean getLock = false;
        try{
            getLock = lock.tryLock();
            System.out.println(Thread.currentThread()+"是否获得锁：" + getLock);
            Thread.sleep(5000);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            /*
            if(getLock){
                lock.unlock();
                System.out.println(Thread.currentThread()+"释放了锁！");
            }

             */
            if(lock.isHeldByCurrentThread()){
                lock.unlock();
                System.out.println(Thread.currentThread()+"释放了锁！");
            }
        }

    }


    public static void main(String[] args) {
        ReentrantLock03 t = new ReentrantLock03();
        new Thread(new Runnable() {
            @Override
            public void run() {
                t.m();
            }
        },"thread-01").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                t.m();
            }
        },"thread-02").start();

    }
}
