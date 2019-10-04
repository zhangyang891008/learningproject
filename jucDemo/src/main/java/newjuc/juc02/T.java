package newjuc.juc02;

public class T {

    int count  = 0;
    public void m(){
        synchronized (this){
            count++;
            System.out.println(Thread.currentThread() + ", count = "+ count);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        T t = new T();
        T t2 = new T();
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    t.m();
                }
            }).start();
        }

        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    t2.m();
                }
            }).start();
        }
    }
}
