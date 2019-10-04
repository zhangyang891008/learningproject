package newjuc.juc17;

public class ObjectLock {
    Object obj = new Object();

    public void m(){
        synchronized (obj){
            System.out.println(Thread.currentThread() + " entering...");
            while(true){

            }

        }
    }
    public static void main(String[] args) {
        ObjectLock l = new ObjectLock();
        new Thread(new Runnable() {
            @Override
            public void run() {
                l.m();
            }
        }).start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        l.obj = new Object();

        new Thread(new Runnable() {
            @Override
            public void run() {
                l.m();
            }
        }).start();
    }
}
