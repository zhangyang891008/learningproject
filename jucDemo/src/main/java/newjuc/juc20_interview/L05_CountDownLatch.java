package newjuc.juc20_interview;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class L05_CountDownLatch {

    List<String> list = new ArrayList<>();
    public void add(String str){
        list.add(str);
    }

    public int size(){
        return list.size();
    }

    public static void main(String[] args) {
        L05_CountDownLatch t = new L05_CountDownLatch();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        new Thread(new Runnable() {
            @Override
            public void run() {
                if(t.size() != 5){
                    try {
                        System.out.println("wait");
                        countDownLatch.await();
                        System.out.println("catch 5");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    if(t.size()==5){
                        countDownLatch.countDown();
                        System.out.println("countdown");
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    t.add("add"+i);
                    System.out.println("add"+i);
                }
            }
        }).start();


    }
}
