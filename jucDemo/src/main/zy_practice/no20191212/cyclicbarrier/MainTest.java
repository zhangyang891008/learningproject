package no20191212.cyclicbarrier;

import no20191212.cyclicbarrier.HorseRace;

/*
java编程思想：仿写CyclicBarrier
 */
public class MainTest {
    public static void main(String[] args) {
        HorseRace horseRace = new HorseRace(7, 1000);
        Thread thread = new Thread(horseRace);
        thread.start();
    }
}
