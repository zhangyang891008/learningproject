package newjuc.juc20_interview;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.LockSupport;

public class L07_LockSupport_02 {
    List<String> list = new ArrayList<>();
    public void add(String str){
        list.add(str);
    }

    public int size(){
        return list.size();
    }
    static Thread t1 = null;
    static Thread t2 = null;

    public static void main(String[] args) {
        L07_LockSupport_02 t = new L07_LockSupport_02();


        t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                if(t.size()!=5){
                    LockSupport.park();
                    System.out.println("catch 5");
                    LockSupport.unpark(t2);
                }
            }
        });
        t1.start();

        t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {

                    if(t.size() ==5){
                        LockSupport.unpark(t1);
                        LockSupport.park();
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
        });
        t2.start();
    }
}
