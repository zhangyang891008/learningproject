package no20191212.cyclicbarrier;

import no20191212.cyclicbarrier.Horse;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HorseRace implements Runnable{
    private List<Horse> horse = new ArrayList<>();
    private ExecutorService executorService;
    private int finishLine ;
    private int horseNum ;
    private CyclicBarrier barrier;

    public HorseRace(int horseNum, int finishLine){
        this.finishLine = finishLine;
        this.horseNum = horseNum;
    }

    @Override
    public void run() {
        executorService = Executors.newFixedThreadPool(horseNum);
        barrier = new CyclicBarrier(horseNum, new Runnable() {
            @Override
            public void run() {
                System.out.println("-----");
                for (Horse h : horse) {
                    System.out.println(h.toString()+"**"+h.steps);
                }
            }
        });

        for (int i = 0; i < horseNum; i++) {
            Horse h = new Horse(barrier);
            horse.add(h);
            executorService.execute(h);
        }

        while (!Thread.interrupted()) {
            for (Horse h : horse) {
                if (h.steps > finishLine) {
                    executorService.shutdownNow();
                    System.out.println("finish!" + h.toString() + ", steps:" + h.steps);
                    return;
                }
            }
        }

    }
}
