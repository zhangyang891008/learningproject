package newjuc.juc20;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 与01号测试类似，用reentrantlock替换synchronized,但是要解锁，synchronized有异常回自动解锁
 */
public class ReentrantLock02 {

    ReentrantLock lock = new ReentrantLock();

    public void m1(){
        try{
            lock.lock();
            System.out.println("m1 starting...**");
            Thread.sleep(5000);
            System.out.println("m1 ending...");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void m2(){
        try{
            lock.lock();
            System.out.println("m2 starting...");
            System.out.println("m2 ending...");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ReentrantLock02 t = new ReentrantLock02();
        new Thread(new Runnable() {
            @Override
            public void run() {
                t.m1();
            }
        }).start();;

        new Thread(new Runnable() {
            @Override
            public void run() {
                t.m2();
            }
        }).start();
    }
}
