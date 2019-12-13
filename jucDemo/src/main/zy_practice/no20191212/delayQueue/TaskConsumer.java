package no20191212.delayQueue;

import java.util.concurrent.DelayQueue;

public class TaskConsumer implements Runnable{
    DelayQueue<DelayTask> queue;
    public TaskConsumer(DelayQueue queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        while(queue.size()>0){
            try {
                queue.take().run();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("consume finished");
    }
}
