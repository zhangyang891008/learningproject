package newjuc.juc05_06;

/**
 * 没有任何同步控制的情况下，数据不一致，计算结果错误
 */
public class T1 implements Runnable{

    private /*volatile*/int count = 0;

    @Override
    public /*synchronized*/ void run() {
        count++;
        System.out.println(count);
    }

    public static void main(String[] args) {
        T1 t = new T1();
        for (int i = 0; i < 1000; i++) {
            new Thread(t, "thread-"+i).start();
        }
    }
}
