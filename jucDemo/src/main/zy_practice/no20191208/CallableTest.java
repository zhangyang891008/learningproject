package no20191208;

import java.util.concurrent.*;

/*
    Callable:实现一个有返回值的任务
 */
public class CallableTest {

    static class MyTask implements Callable<String>{
        @Override
        public String call() throws Exception {
            TimeUnit.SECONDS.sleep(5);
            return "test";
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Future<String> submit = executorService.submit(new MyTask());
        try {
            String s = submit.get();
            System.out.println(s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("execute finished");

    }
}
