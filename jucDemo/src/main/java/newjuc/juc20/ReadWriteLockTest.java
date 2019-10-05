package newjuc.juc20;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁：读读不互斥，读写，写写互斥
 */
public class ReadWriteLockTest {

    int read = 0;
    int write = 0;

    static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    static Lock writeLock = lock.writeLock();
    static Lock readLock = lock.readLock();

    public void readMethod(){
        try{
            readLock.lock();
            System.out.println("read..." + (++read));
            Thread.sleep(2000);
            System.out.println("read..."+ (read)+" end..");
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            readLock.unlock();
        }
    }
    public void writeMethod(){
        try{
            writeLock.lock();
            System.out.println("***write..." + (++write)+"--------");
            Thread.sleep(2000);
            System.out.println("***write... "+ (write)+" end-------");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            writeLock.unlock();
        }

    }

    public static void main(String[] args) {
        ReadWriteLockTest t = new ReadWriteLockTest();
        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(Math.round(1000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    t.readMethod();
                }
            }).start();
        }

        for (int i = 0; i < 5; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(Math.round(1000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    t.writeMethod();
                }
            }).start();

        }
    }


}
