package newjuc.juc09_juc10;

/**
 * 一个同步方法可以调用另一个同步方法，一个线程一旦获得了某个对象的锁，再次申请仍然会获得这个锁
 */
public class T {

    public synchronized void m1(){
        System.out.println(Thread.currentThread()+" entering m1...");
        m2();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread()+ " leaving m1...");
    }

    public synchronized void m2(){
        System.out.println(Thread.currentThread()+" entering m2...");
        System.out.println(Thread.currentThread()+" leaving m2...");

    }

    public static void main(String[] args) {
        T t = new T();
        new Thread(new Runnable() {
            @Override
            public void run() {
                t.m1();
            }
        }).start();

    }
}
