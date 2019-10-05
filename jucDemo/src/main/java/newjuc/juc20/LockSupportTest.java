package newjuc.juc20;

import java.util.concurrent.locks.LockSupport;

/**
 * LockSupport:
 */
public class LockSupportTest {

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    if(i==5){
                        LockSupport.park();
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("-----"+i);

                }
            }
        });
        t1.start();


        try {
            Thread.sleep(12000);
            LockSupport.unpark(t1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
