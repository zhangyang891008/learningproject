package newjuc.juc01;

/**
 * synchornized,所有线程要访问方法必须先获得锁
 */
public class T {

    static Object o = new Object();
    static int count = 0;

    public static void add(){
       // synchronized (o){
            System.out.println(Thread.currentThread().getName() + "-----"+(count++));
       // }
    }

    public static void main(String[] args) {

        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    add();
                }
            }).start();

        }

    }
}
