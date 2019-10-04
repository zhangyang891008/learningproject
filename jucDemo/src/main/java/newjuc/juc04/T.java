package newjuc.juc04;

/**
 * 类锁和对象锁
 */
public class T {

    public void m(){
        synchronized (this){
            //T.class是否可以用this代替？  如果改成this，T创建的多个不同的对象，将有可能同时执行此方法，因为this是对象锁
            System.out.println("entering...");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("leaving...");
        }

    }

    public static void m2(){

    }

    public static void main(String[] args) {
        T t = new T();
        T t2 = new T();
        new Thread(new Runnable() {
            @Override
            public void run() {
                t.m();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                t2.m();
            }
        }).start();

    }
}
