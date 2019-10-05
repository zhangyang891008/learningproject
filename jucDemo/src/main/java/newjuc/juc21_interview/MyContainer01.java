package newjuc.juc21_interview;

import java.util.LinkedList;
import java.util.List;

/**
 * 面试题：写一个固定容量的同步容器，拥有put和get方法，以及getCount()方法，
 * 支持两个生产者线程和10个消费者线程的阻塞调用
 *
 * 使用wait,notify/notifyAll来实现
 */
public class MyContainer01<T> {

    List<T> list = new LinkedList<>();
    int count = 0;
    int MAX = 10;
    Object o = new Object();

    public void put(T t){
        synchronized (o){
            while(list.size() == MAX){ //为什么是while?因为被唤醒以后还是要判断是否符合条件。
                try {
                    o.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            list.add(t);
            count++;

            o.notifyAll();
        }
    }

    public T get(){
        T t = null;
        synchronized (o){
            while(list.size()<=0){
                try {
                    o.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            T remove = list.remove(0);
            count--;
            o.notifyAll();
            return remove;
        }
    }

    public static void main(String[] args) {
        MyContainer01 container = new MyContainer01();
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
