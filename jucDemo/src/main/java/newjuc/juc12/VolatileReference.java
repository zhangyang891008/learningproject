package newjuc.juc12;

/**
 * volatile只能保证本身的可见性，其内部的属性不保证可见
 */
public class VolatileReference {

    boolean running = true;
    static volatile VolatileReference t = new VolatileReference();

    public void running(){
        System.out.println("start...");
        while(running){
        }
        System.out.println("ending...");
    }

    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                VolatileReference.t.running();
            }
        }).start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        VolatileReference.t.running = false;

    }

}
