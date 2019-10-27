package juc.class02;

public class T17_ObjectLockChange {

    Object object = new Object();

    public void m(){
        synchronized (object){
            System.out.println(Thread.currentThread().getName()+"enter");

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            object = new Object();

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"leave");
        }
    }

    public static void main(String[] args) {
        T17_ObjectLockChange t = new T17_ObjectLockChange();
        new Thread(new Runnable() {
            @Override
            public void run() {
                t.m();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                t.m();
            }
        }).start();
    }
}
