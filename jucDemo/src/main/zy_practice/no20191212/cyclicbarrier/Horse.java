package no20191212.cyclicbarrier;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Horse implements Runnable{

    CyclicBarrier barrier;
    int steps = 0;
    Random random = new Random();

    public Horse(CyclicBarrier barrier){
        this.barrier = barrier;
    }

    @Override
    public void run() {
        while(!Thread.interrupted()){
            steps += random.nextInt(10);
            try {
                barrier.await();
            } catch (InterruptedException e) {

            } catch (BrokenBarrierException e) {
               throw new RuntimeException("broke");
            }
        }
    }
}
