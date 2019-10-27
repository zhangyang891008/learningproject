package juc.class01.c000;

/*
    join方法测试
 */
public class T03_Field_Sleep_Join {

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("bye");
            }
        });

        Thread t2 = new Thread(()->{
            System.out.println("I am coming!!!");
            try {
                t1.join();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("hello google");
        });

        t2.start();
        t1.start();
    }
}
