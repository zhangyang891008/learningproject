package com.juc.volatile2;

/**
 * volatile: 工作内存（栈），主内存（堆），CPU三级缓存（更新数据及时性）
 *
 */
public class VolatileTest
{
    public static volatile boolean running = true;

    public static void main( String[] args ) throws InterruptedException {
        Thread workingThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while(running) {

                }
                System.out.println("end...");
            }
        });

        workingThread.start();
        Thread.sleep(2000);
        running = false;

    }
}
