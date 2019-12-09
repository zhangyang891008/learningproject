package no20191209;

import java.util.concurrent.TimeUnit;

/*
测试在阻塞和非阻塞的情况下，中断线程的效果：
    进入while循环之前中断，会直接跳过while
    如果进入while循环，阻塞前到阻塞中时，将响应中断，
    过了sleep以后，将于下次while判断为false后退出while，打印after while
 */
public class InterruptTest {

    static class MyThread implements Runnable{
        @Override
        public void run() {
            while(!Thread.interrupted()){
                System.out.println("inter");
                try {
                    System.out.println("before");
                    TimeUnit.SECONDS.sleep(2);
                    System.out.println("after");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    System.out.println("interruptException...");
                }
            }
            System.out.println("after while");
        }
    }
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new MyThread());
        t.start();
       // t.join(1000);
        t.interrupt();
    }
}
