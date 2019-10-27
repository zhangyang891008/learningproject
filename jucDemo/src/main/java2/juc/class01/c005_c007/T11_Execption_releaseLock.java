package juc.class01.c005_c007;

/*
    运行异常会导致锁释放，会让其他线程有机会运行，会导致数据不一致
 */
public class T11_Execption_releaseLock {

    int count = 0;
    synchronized void m(){
        System.out.println(Thread.currentThread().getName()+" entered!");
        while(true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count++;
            if(count==5){
                throw new RuntimeException("Exception!");
            }
            System.out.println(count);
        }
    }

    public static void main(String[] args) {

        T11_Execption_releaseLock t = new T11_Execption_releaseLock();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                t.m();
            }
        });

        t1.start();
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                t.m();
            }
        });
        t2.start();
    }
}
