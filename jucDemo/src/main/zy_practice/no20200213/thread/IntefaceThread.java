package no20200213.thread;

public class IntefaceThread implements Runnable {

    @Override
    public void run() {
        System.out.println("----InterfaceThread----");
        System.out.println(this);
        System.out.println(Thread.currentThread());
        System.out.println("----InterfaceThread end---");
    }
}
