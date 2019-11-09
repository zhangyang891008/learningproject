package chapter05.lock;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/*
    AQS:同步器是实现锁的关键，
        锁是面向使用者的，它定义了使用者和锁交互的接口，隐藏了细节；
        同步器面向锁的使用者,简化了锁的实现，屏蔽了同步状态管理，线程的排队，等待和唤醒等底层操作；
        锁和同步器隔离了使用者和实现者需要关注的领域。
 */
public class Mutex implements Lock {

    private final Sync sync = new Sync();

    private  static class Sync extends AbstractQueuedSynchronizer{
        @Override
        protected boolean tryAcquire(int arg) {
            if(compareAndSetState(0,1)){
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }

        @Override
        protected boolean tryRelease(int arg) {
            if(getState() == 0){
                //this is a runtimeException
                throw new IllegalMonitorStateException();
            }
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }

        @Override
        protected boolean isHeldExclusively() {
            return getState() == 1;
        }

        protected Condition newCondition(){
            return new ConditionObject();
        }

    }


    @Override
    public void lock() {
        sync.acquire(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        sync.acquireInterruptibly(1);
    }

    @Override
    public boolean tryLock() {
        return sync.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return sync.tryAcquireNanos(1, unit.toNanos(time));
    }

    @Override
    public void unlock() {
        sync.release(1);
    }

    @Override
    public Condition newCondition() {
        return sync.newCondition();
    }

    public boolean hasQueuedThreads(){
        return sync.hasQueuedThreads();
    }

    public Collection<Thread> getQueuedThreads(){
        return sync.getQueuedThreads();
    }

    public static void main(String[] args) {
        final Mutex m = new Mutex();

        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Thread t = new Thread(()->{
                m.lock();
                try{
                    System.out.println(Thread.currentThread()+" entered");
                    Thread.sleep(1000);
                    System.out.println("***");
                    if(m.hasQueuedThreads()){
                        m.getQueuedThreads().stream().forEach(System.out::println);
                    }
                    System.out.println("***");
                } catch (Exception e){
                    e.printStackTrace();
                } finally {
                    System.out.println(Thread.currentThread()+" left");
                    m.unlock();
                }
            },"thread-"+i);
            threads.add(t);
        }


        for (Thread thread : threads) {
            thread.start();
        }

        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
