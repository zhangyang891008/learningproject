package no20191214;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * priorityBlockingQueue
 */
public class MainTest {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        PriorityBlockingQueue queue = new PriorityBlockingQueue();
        exec.execute(new Producer(exec,queue));
        exec.execute(new Consumer(queue));
        Thread.sleep(10000);
        exec.shutdownNow();
    }
}
