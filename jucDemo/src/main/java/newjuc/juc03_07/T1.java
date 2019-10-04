package newjuc.juc03_07;

/**
 * synchronized不加锁的方法可以正常访问
 */

public class T1 {

    public synchronized void m(){
        System.out.println("m: " + Thread.currentThread()+ " entering...");
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("m: " + Thread.currentThread()+ " leaving...");
    }

    public void m2(){

        System.out.println("m2: " + Thread.currentThread() + " coming...");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("m2: " + Thread.currentThread() + " going...");
    }


    public static void main(String[] args) {
        T1 t = new T1();

        //1.测试加锁方法访问
        /*
        for (int i = 0; i < 5; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    t.m();
                }
            }).start();

        }*/

        //2.测试访问无锁方法
        /*
        for (int i = 0; i < 5; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    t.m2();
                }
            }).start();
        }
*/

        //3.测试在访问加锁方法的时候，不加锁方法能不能访问
        new Thread(new Runnable() {
            @Override
            public void run() {
                t.m();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                t.m2();
            }
        }).start();

    }

}