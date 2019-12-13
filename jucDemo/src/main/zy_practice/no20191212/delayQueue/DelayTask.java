package no20191212.delayQueue;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayTask implements Runnable, Delayed {

    public long getTrigger() {
        return trigger;
    }

    public void setTrigger(long trigger) {
        this.trigger = trigger;
    }

    private long trigger;

    public DelayTask(int delta){
        trigger = System.currentTimeMillis() + delta;
    }

    @Override
    public int compareTo(Delayed o) {
        DelayTask oTask = (DelayTask) o;
        return this.getTrigger() < ((DelayTask) o).getTrigger()? -1:1;
    }

    @Override
    public void run() {
        System.out.println(this.toString()+"... running"+"--"+trigger);
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(trigger-System.currentTimeMillis(),TimeUnit.MILLISECONDS);
    }
}
