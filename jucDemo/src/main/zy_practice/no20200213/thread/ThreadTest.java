package no20200213.thread;

public class ThreadTest {

    private static void testInterface(){
        System.out.println(Thread.currentThread());
        Thread t = new Thread(new IntefaceThread());
        t.start();
    }

    private static void testExtend(){
        System.out.println(Thread.currentThread());
        ClassThread t = new ClassThread();
        t.start();
    }

    public static void main(String[] args) throws InterruptedException {
        testExtend();
        Thread.sleep(2000);
        System.out.println("");
        testInterface();
    }
}

