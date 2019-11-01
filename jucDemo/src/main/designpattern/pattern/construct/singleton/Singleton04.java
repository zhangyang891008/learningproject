package pattern.construct.singleton;

import java.util.ArrayList;
import java.util.List;

/**
 * 单例模式：枚举方式
 */
public class Singleton04 {

    enum MySingleton{
        INSTANCE;
        private Singleton04 singleton04;
        private MySingleton(){
            singleton04 = new Singleton04();
        }

        public Singleton04 getInstance(){
            return singleton04;
        }
    }

    public static final Singleton04 getInstance(){
        return MySingleton.INSTANCE.getInstance();
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
