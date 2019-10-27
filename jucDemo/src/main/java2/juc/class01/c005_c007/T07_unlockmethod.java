package juc.class01.c005_c007;


/*
    加锁方法可以调用无锁方法
 */
public class T07_unlockmethod {

    public synchronized void m1() {
        System.out.println("m1 enter");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        m2();

        System.out.println("m1 end...");
    }

    public void m2() {
        System.out.println("m2 enter");
    }

    public static void main(String[] args) {
        T07_unlockmethod t = new T07_unlockmethod();
        t.m1();

    }
}