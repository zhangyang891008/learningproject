package newjuc.juc12;

/**
 * volatile具有可见性，保证先写后读，避免变量在线程间不可见。
 */
public class VolatileVisiable {
    volatile boolean running = true;

    public void keepRunning(){
        System.out.println("start running...");
        while(running){
        }
        System.out.println("stop running...");
    }


    public static void main(String[] args) {
        VolatileVisiable v = new VolatileVisiable();
        //v.keepRunning();
        new Thread(new Runnable() {
            @Override
            public void run() {
                v.keepRunning();
            }
        }).start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        v.running = false;
        System.out.println("..."+v.running);

    }
}
