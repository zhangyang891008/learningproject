package com.juc.volatile2;

/**
 * volatile : 发现，CPU资源一直被占用的情况下，是来不及更新的。但是
 *
 */
public class VolatileTest2
{
    public /*volatile */ boolean runnning = true;

    public void m() throws InterruptedException {
        Object o = null;
        System.out.println("start...");
        while(runnning){
            //Thread.sleep(1000);   //加了这个sleep以后，就可以获取到修改的running？？？
            //System.out.println("test");  //获取到更新
            //o = new Object();   //不会获取到更新
            byte[] b = new byte[1024];  //不会获取到更新
        }
        System.out.println("end...");
    }

    public static void main( String[] args ) throws InterruptedException {
        final VolatileTest2 t = new VolatileTest2();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    t.m();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        Thread.sleep(1000);
        t.runnning = false;
    }
}
