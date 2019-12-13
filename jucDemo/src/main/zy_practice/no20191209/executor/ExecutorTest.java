package no20191209.executor;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 仿写Executors创建线程池
 */
public class ExecutorTest {

    public static void m2() throws InterruptedException {
        int core = 1;
        int max = 5;
        //BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();
        //BlockingQueue<Runnable> queue = new SynchronousQueue<>();
        BlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(1);
        MyRejectedExecutionHandler myRejectedExecutionHandler = new MyRejectedExecutionHandler();

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(core, core,
                0, TimeUnit.MILLISECONDS, queue, new MyThreadFactory(), myRejectedExecutionHandler);

        int times = 10;
        for (int i = 0; i < times; i++) {
           threadPoolExecutor.execute(new MyTask("my task --" + i));
        }

        Thread.sleep(10000);
        System.out.println("sleep");
        myRejectedExecutionHandler.showRejectTasks();
    }

    private static class MyTask implements Runnable{
        String name = null;
        public MyTask(String taskName){
            name = taskName;
        }

        @Override
        public void run() {
            try {
                System.out.println(name+ " is executing...");
                TimeUnit.SECONDS.sleep(1);
                System.out.println(name + "is finished");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override
        public String toString() {
            return super.toString() + " -taskname:" + name;
        }
    }

    private static class MyRejectedExecutionHandler implements RejectedExecutionHandler{

        ConcurrentHashMap<Runnable, ThreadPoolExecutor> rejectTask = new ConcurrentHashMap<>();
        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            rejectTask.put(r, executor);
        }

        public void showRejectTasks(){
            for (Runnable runnable : rejectTask.keySet()) {
                System.out.println(runnable.toString());
            }
        }
    }


    private static class MyThreadFactory implements ThreadFactory{
        ThreadGroup group = new ThreadGroup("MyThreadGroup");
        String threadNamePrefix = "MyThreadPrefix";
        private static AtomicInteger serialNumber = new AtomicInteger(0);
        @Override
        public Thread newThread(Runnable r) {
            Thread thread = new Thread(group, r,threadNamePrefix + serialNumber.getAndIncrement());
            thread.setDaemon(false);
            if(thread.getPriority() != Thread.NORM_PRIORITY){
                thread.setPriority(Thread.NORM_PRIORITY);
            }
            return thread;
        }
    }

    public static void main(String[] args) {
        try {
            ExecutorTest.m2();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
