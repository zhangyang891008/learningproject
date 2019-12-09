package no20191208;

import java.util.concurrent.TimeUnit;

public class UnCaughtExceptionHandlerTest {

    static class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler{
        @Override
        public void uncaughtException(Thread t, Throwable e) {
            System.out.println("MyUncaughtExceptionHandler:" + e);
        }
    }

    static class MyTask implements Runnable{

        @Override
        public void run() {
            throw new RuntimeException("My test throw exception");
        }
    }


    public static void main(String[] args) throws InterruptedException {
        try{
            m1();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void m1() throws InterruptedException {
        Thread t = new Thread(new MyTask());
        t.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        t.start();
        TimeUnit.SECONDS.sleep(1);
        Thread t2 =  new Thread(new MyTask());
        t2.start();
        System.out.println(t2.getDefaultUncaughtExceptionHandler());
        System.out.println(Thread.getDefaultUncaughtExceptionHandler());
    }

}
