package newjuc.juc20_interview;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.LockSupport;

public class L06_LockSupport {
    List<String> list = new ArrayList<>();
    public void add(String str){
        list.add(str);
    }

    public int size(){
        return list.size();
    }

    public static void main(String[] args) {
        L06_LockSupport t = new L06_LockSupport();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                if(t.size()!=5){
                    LockSupport.park();
                    System.out.println("catch 5");
                }
            }
        });
        t1.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {

                    if(t.size() ==5){
                        LockSupport.unpark(t1);
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    t.add("add"+i);
                    System.out.println("add---"+i);
                }
            }
        }).start();
    }
}
