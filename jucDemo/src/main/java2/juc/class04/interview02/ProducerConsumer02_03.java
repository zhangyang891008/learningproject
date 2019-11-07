package juc.class04.interview02;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
    生产者消费者问题：synchronized版本实现
 */
public class ProducerConsumer02_03<T> {

    private List<T> products = new LinkedList<>();
    private static final int MAX = 10;

    private final Lock LOCK = new ReentrantLock();
    private Condition producer = LOCK.newCondition();
    private Condition consumer = LOCK.newCondition();

    public void produce(Producable<? super T> t){
        try{
            LOCK.lock();
            while(products.size() >= MAX){
                producer.await();
            }
            products.add((T) t);
            consumer.signalAll();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            LOCK.unlock();
        }
    }

    public Producable<? super T> consume(){
        try{
            LOCK.lock();
            while(products.size() <= 0){
                consumer.await();
            }
            T remove = products.remove(0);
            producer.signalAll();
            return (Producable<? super T>) remove;
        } catch (Exception e){
            e.printStackTrace();
            return null;
        } finally{
            LOCK.unlock();
        }
    }

    public static void main(String[] args) {
        ProducerConsumer02_03<Product> t = new ProducerConsumer02_03<>();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    t.produce(new Product(i));
                }
            }
        });
        t1.start();
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    Producable<? super Product> p = t.consume();
                    System.out.println("consume:"+p);
                }
            }
        });
        t2.start();
    }

}
