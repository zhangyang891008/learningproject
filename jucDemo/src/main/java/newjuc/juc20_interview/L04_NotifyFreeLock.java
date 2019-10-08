package newjuc.juc20_interview;

import java.util.LinkedList;
import java.util.List;

public class L04_NotifyFreeLock {
    List<String> list = new LinkedList<>();
    public void add(String str){
        list.add(str);
    }

    public int size(){
        return list.size();
    }

    public static void main(String[] args) {
        Object lock = new Object();
        L04_NotifyFreeLock t = new L04_NotifyFreeLock();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock){
                    if(t.size() != 5){
                        try {
                            lock.wait();
                            System.out.println("catch 5");
                            lock.notify();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock){
                    for (int i = 0; i < 10; i++) {
                        if(t.size()==5){
                            lock.notify();
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("add --"+i);
                        t.add("add"+i);
                    }
                }
            }
        }).start();
    }
}
