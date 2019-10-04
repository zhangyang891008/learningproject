package newjuc.juc11;

/**
 *当程序执行过程中，如果出现异常，会释放锁，有可能导致数据不一致，因此要小心。
 * 如果不希望异常释放锁，要用catch捕获异常，继续执行后续代码
 *
 */
public class T {

    public synchronized  void m(){
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread()+ "-----"+i);
            if(i==5){
                throw new RuntimeException();
            }
        }
    }

    public static void main(String[] args) {
        T t = new T();
        new Thread(new Runnable() {
            @Override
            public void run() {
                t.m();
            }
        },"firstThread").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                t.m();
            }
        },"secondThread").start();
    }
}
