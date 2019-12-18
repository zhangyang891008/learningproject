package no20191214;

import java.util.Random;
import java.util.concurrent.PriorityBlockingQueue;

public class Consumer implements  Runnable {
    PriorityBlockingQueue<PriorityTask> queue;
    Random random = new Random(47);

    public Consumer(PriorityBlockingQueue queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        System.out.println("consume start");
        while(!Thread.interrupted()){
            try {
                queue.take().run();
            } catch (InterruptedException e) {
                //e.printStackTrace();
            }
        }
        System.out.println("consume finish!");
    }
}
