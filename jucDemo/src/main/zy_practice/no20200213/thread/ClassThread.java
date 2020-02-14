package no20200213.thread;

public class ClassThread extends  Thread {
    @Override
    public void run() {
        System.out.println("----classThread---");
        System.out.println(this);
        System.out.println(Thread.currentThread());
        System.out.println("----classThread end---");
    }

    public String toString() {
        return "ClassThread";
    }

}
