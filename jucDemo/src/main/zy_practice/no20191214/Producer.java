package no20191214;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.PriorityBlockingQueue;

public class Producer implements Runnable {

    private PriorityBlockingQueue queue;
    private ExecutorService exec;
    public Producer(ExecutorService exec, PriorityBlockingQueue queue){
        this.exec = exec;
        this.queue = queue;
    }

    @Override
    public void run() {
        System.out.println("producer start");
        for (int i = 10; i >0; i--) {
            queue.put(new PriorityTask("task"+i,100+i));
        }
    }
}
