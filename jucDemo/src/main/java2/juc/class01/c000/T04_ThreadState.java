package juc.class01.c000;

/*
    线程运行状态测试
    一般包括6个状态：1。new 2。ready 3running 4 waiting、timed-waiting 5blocked 6terminated
 */
public class T04_ThreadState {

    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("thread finish");
            }
        });
        System.out.println(t.getState());
        t.start();
        System.out.println(t.getState());

        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(t.getState());
    }
}
