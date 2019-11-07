package juc.class04.interview02;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
    生产者消费者问题：synchronized版本实现
 */
public class ProducerConsumer01 {

    private List<Product> products = new LinkedList<>();
    private static final int MAX = 10;

    private final Object LOCK = new Object();

    public void produce(Product p){
        synchronized (LOCK){
            while(products.size() >= MAX){
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            products.add(p);
            LOCK.notifyAll();
        }
    }

    public Product consume(){
        synchronized (LOCK){
            while(products.size() <= 0){
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Product p = products.remove(0);
            LOCK.notifyAll();
            return p;
        }
    }

    public static void main(String[] args) {
        ProducerConsumer01 p = new ProducerConsumer01();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    p.produce(new Product(i));
                }
            }
        });
        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    Product product = p.consume();
                    System.out.println("consume: " + product);
                }
            }
        });

        t2.start();
    }

}
