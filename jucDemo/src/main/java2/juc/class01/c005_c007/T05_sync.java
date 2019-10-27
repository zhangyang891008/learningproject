package juc.class01.c005_c007;

/*
    无锁情况下，多线程并发修改同一个变量会导致数据不一致问题
 */
public class T05_sync {
    public int count = 1000;

    public void m(){
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count--;System.out.println(count);
    }

    public static void main(String[] args) {
        T05_sync t = new T05_sync();

        for (int i = 0; i < 1000; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    t.m();
                }
            }).start();
        }

    }
}
