package newjuc.juc20_interview;

import java.util.LinkedList;
import java.util.List;

public class L03_NotifyHoldingLock {
    List<String> list = new LinkedList<>();


    public void add(String str){
        list.add(str);
    }

    public int size(){
        return list.size();
    }

    public static void main(String[] args) {
        L03_NotifyHoldingLock t = new L03_NotifyHoldingLock();
        final Object o = new Object();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (o){
                    if(t.size() != 5){
                        try {
                            System.out.println("wait enter...");
                            o.wait();
                            System.out.println("count 5...");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        o.notify();
                    }
                }

            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (o){
                    for (int i = 0; i < 10; i++) {
                        if(t.size()==5){
                            o.notify();
                            System.out.println("notify");
                        }
                        t.add("add"+i);
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("add --" + i);
                    }
                }

                System.out.println("loop end");

            }
        }).start();
    }
}
