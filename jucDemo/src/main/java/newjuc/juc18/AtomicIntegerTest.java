package newjuc.juc18;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * atomic包中的类中的方法都是具有原子性的
 * 但是，两次调用之间不具有原子性，需要加synchronized保证原子性
 *
 */
public class AtomicIntegerTest {

   AtomicInteger count = new AtomicInteger(0);
   public void add(){
       for (int i = 0; i < 1000; i++) {
           count.getAndIncrement();
       }
   }

   /*此方法只有在加锁synchronized情况下是保证原子性的*/
   public /* synchronized*/ void add2(){
       for (int i = 0; i < 100; i++) {
           int andIncrement = count.getAndIncrement();
           try {
               Thread.sleep(1);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
           count.getAndSet(andIncrement+1);
       }
   }

    public static void main(String[] args) {
        AtomicIntegerTest t = new AtomicIntegerTest();
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            threads.add(new Thread(new Runnable() {
                @Override
                public void run() {
                    //t.add();
                    t.add2();
                }
            }));
        }

        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("total : " + t.count);
    }


}
