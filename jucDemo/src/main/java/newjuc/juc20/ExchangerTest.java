package newjuc.juc20;

import java.util.concurrent.Exchanger;

/**
 * Exchanger:用于两个线程之间交换值
 */
public class ExchangerTest {
    public static Exchanger exchanger = new Exchanger();
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Object hello = null;
                try {
                    hello = exchanger.exchange("bye");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("I am thread-1 ->"+ hello.toString());
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                Object hello = null;
                try {
                    hello = exchanger.exchange("hello");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("I am thread-2 ->"+ hello.toString());
            }
        }).start();
    }
}
