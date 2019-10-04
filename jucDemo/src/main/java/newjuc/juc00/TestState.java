package newjuc.juc00;

public class TestState {

    static class MyThread extends Thread
    {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("my thread running");
            }
        }
    }

    public static void main(String[] args) {
        Thread t = new MyThread();
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("main running...");

    }
}
