package pattern.construct.singleton;

import java.util.ArrayList;
import java.util.List;

/**
 * 单例模式：饿汉模式，在类初始化的时候就创建对象
 */
public class Singleton01 {
    private static final Singleton01 INSTANCE = new Singleton01();
    private Singleton01(){

    }

    public static final Singleton01 getInstance(){
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
