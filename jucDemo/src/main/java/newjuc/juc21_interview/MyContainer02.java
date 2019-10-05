package newjuc.juc21_interview;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 面试题：写一个固定容量的同步容器，拥有put和get方法，以及getCount()方法，
 * 支持两个生产者线程和10个消费者线程的阻塞调用
 *
 * 使用ReentrantLock的不同condition,让等待消费和等待生产的线程在不同的等待队列中
 */
public class MyContainer02<T> {
    List<T> list = new LinkedList<>();
    int MAX= 10;
    int count = 0;

    ReentrantLock lock = new ReentrantLock();
    Condition notFull = lock.newCondition();
    Condition notEmpty = lock.newCondition();

    public T get(){
        T remove = null;
        try{
            lock.lock();
            while(list.size() <= 0){
                notEmpty.await();
            }
            remove = list.remove(0);
            count--;
            notFull.signalAll();
        }catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
        return remove;
    }

    public void put(T t){
        try{
            lock.lock();
            while(list.size()==MAX){
                notFull.await();
            }
            list.add(t);
            count++;
            notEmpty.signalAll();
        }catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }

    public static void main(String[] args) {
        MyContainer02 container = new MyContainer02();
        for (int i = 0; i < 2; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 10; j++) {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        container.put(Thread.currentThread()+"-"+j);
                        System.out.println("Thread-"+j+" produce-- " + Thread.currentThread()+"-"+j);
                    }
                }
            }).start();
        }

        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while(true){
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        Object o = container.get();
                        System.out.println( "---consume: " + o.toString());
                    }
                }
            }).start();
        }

    }

}
