package newjuc.juc16;

import java.util.ArrayList;
import java.util.List;

/**
 * 同步代码块中的代码越少越好！
 */
public class LockScope {

    int count = 0;

    public synchronized void m(){
        for (int i = 0; i < 10000; i++) {
            try {
                Thread.sleep(2);  //246700
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count++;
            System.out.println(count);
        }
    }

    public void m2(){
        for (int i = 0; i < 10000; i++) {
            try {
                Thread.sleep(2); //24429
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (this){
                count++;
            }
            System.out.println(count);
        }
    }

    public static void main(String[] args) {
        LockScope l = new LockScope();
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            threads.add(new Thread(new Runnable() {
                @Override
                public void run() {
                    l.m2();
                }
            }));
        }

        long mstart = System.currentTimeMillis();

        for (Thread thread :threads){
            thread.start();
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        long mEnd = System.currentTimeMillis();
        System.out.println("finish:" + (mEnd - mstart));

    }

}
