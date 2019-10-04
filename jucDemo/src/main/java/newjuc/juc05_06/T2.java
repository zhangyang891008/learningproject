package newjuc.juc05_06;

public class T2 implements Runnable {

    private volatile int count = 0;

    static Object o = new Object();
    @Override
    public void run() {
        synchronized (o){
            count++;
            System.out.println(count);
        }
    }

    public static void main(String[] args) {
        T2 t = new T2();
        for (int i = 0; i < 1000; i++) {
            new Thread(t,"thread-"+i).start();
        }
    }
}
