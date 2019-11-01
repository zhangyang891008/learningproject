package pattern.construct.singleton;

import com.juc.volatile2.SynchronizedTest;

import java.util.ArrayList;
import java.util.List;

/**
 * 双重锁校验 DCL
 */
public class Singleton03 {

    private static volatile Singleton03 INSTANCE;

    private Singleton03(){

    }

    public static final Singleton03 getInstance(){

        if(INSTANCE == null){
            synchronized (Singleton03.class){
                if(INSTANCE==null){
                    INSTANCE = new Singleton03();
                }
            }
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            threads.add(new Thread(new Runnable() {
                @Override
                public void run() {
                    //Singleton01.getInstance();
                    System.out.println(Singleton01.getInstance());
                }
            }));
        }

        for (Thread thread : threads) {
            thread.start();
        }

    }
}
