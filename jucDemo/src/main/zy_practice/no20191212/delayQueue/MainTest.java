package no20191212.delayQueue;

import java.util.Random;
import java.util.concurrent.DelayQueue;

public class MainTest {

    public static void main(String[] args) {
        Random random = new Random();
        DelayQueue<DelayTask> tasks = new DelayQueue<>();
        for (int i = 0; i < 5; i++) {
            DelayTask delayTask = new DelayTask(random.nextInt(50000));
            tasks.put(delayTask);
        }

        TaskConsumer taskConsumer = new TaskConsumer(tasks);
        Thread t = new Thread(taskConsumer);
        t.start();
    }
}
