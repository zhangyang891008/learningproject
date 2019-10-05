package newjuc.juc20;

/**
 * 回顾synchronized加对象锁的使用
 */
public class ReentrantLock01 {

    public synchronized void m1(){
        System.out.println("m1 starting...");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("m1 ending...");
    }

    public synchronized void m2(){
        System.out.println("m2 staring...");
        System.out.println("m2 ending...");
    }


    public static void main(String[] args) {
        ReentrantLock01 t = new ReentrantLock01();
        new Thread(new Runnable() {
            @Override
            public void run() {
                t.m1();
            }
        }).start();;

        new Thread(new Runnable() {
            @Override
            public void run() {
                t.m2();
            }
        }).start();

    }
}
