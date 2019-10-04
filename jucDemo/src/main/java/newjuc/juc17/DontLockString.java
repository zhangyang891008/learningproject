package newjuc.juc17;

/**
 * String的内容在程序执行一秒钟以后被修改，另外的线程在之前线程没有释放锁的情况下，同样可以访问同步方法，因此此时锁的对象已经被修改了。
 */
public class DontLockString {

    String lock = "abc";

    public void m(){
        synchronized (lock){
            System.out.println(Thread.currentThread() + " m entering...");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread() +" m leaving...");
        }

    }

    public static void main(String[] args) {
        DontLockString d = new DontLockString();
        new Thread(new Runnable() {
            @Override
            public void run() {
                d.m();
            }
        }).start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        d.lock = "changed!";
        new Thread(new Runnable() {
            @Override
            public void run() {
                d.m();
            }
        }).start();

    }
}
