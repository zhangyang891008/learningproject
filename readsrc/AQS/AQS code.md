



## AQS code

### 排它锁的情况

###### doAcquireInterruptibly -java8

```
/**
 * Acquires in exclusive interruptible mode.
 * @param arg the acquire argument
 */
private void doAcquireInterruptibly(int arg)
    throws InterruptedException {
    final Node node = addWaiter(Node.EXCLUSIVE);
    boolean failed = true;
    try {
        for (;;) {
        		//检查当前节点的前驱节点是否获得共享资源，如果成功则将自己设置为头节点
            final Node p = node.predecessor();
            if (p == head && tryAcquire(arg)) {
                setHead(node);
                p.next = null; // help GC
                failed = false;
                return;
            }
            //在节点处于signal状态下，如果产生中断，则抛出中断异常；否则循环等待
            if (shouldParkAfterFailedAcquire(p, node) &&
                parkAndCheckInterrupt())
                throw new InterruptedException();
        }
    } finally {
        if (failed)
            cancelAcquire(node);
    }
}
```

###### addWaiter

```
private AbstractQueuedSynchronizer.Node addWaiter(AbstractQueuedSynchronizer.Node mode) {
		//根据参数mode的类型创建节点，可以创建SHARED\EXCLUSIVEW两种节点
    AbstractQueuedSynchronizer.Node node = new AbstractQueuedSynchronizer.Node(mode);
		//创建临时节点保存尾节点
    AbstractQueuedSynchronizer.Node oldTail;
    do {
        while(true) {
            oldTail = this.tail;
            //存在尾节点，则设置当前节点的前驱为尾节点
            if (oldTail != null) {
                node.setPrevRelaxed(oldTail);
                break;
            }
						//不存在尾节点，说明没有等待队列，需要创建
            this.initializeSyncQueue();
        }
    } while(!this.compareAndSetTail(oldTail, node));  //CAS的方式将尾节点设置为当前节点
		//将旧尾节点的后继设置为新的尾节点
    oldTail.next = node;
    return node;
}
```

###### doAcquireInterruptibly-in java11

```
private void doAcquireInterruptibly(int arg) throws InterruptedException {
    AbstractQueuedSynchronizer.Node node = this.addWaiter(AbstractQueuedSynchronizer.Node.EXCLUSIVE);

    try {
        AbstractQueuedSynchronizer.Node p;
        do {
        		//当前节点的前驱节点p,如果是头节点并且通过tryAcquire()成功，就把当前节点设置为头节点，这个是成功的情况
            p = node.predecessor();
            if (p == this.head && this.tryAcquire(arg)) {
                this.setHead(node);
                p.next = null;
                return;
            }
            //this.parkAndCheckInterrupt()检查是否有中断。
        } while(!shouldParkAfterFailedAcquire(p, node) || !this.parkAndCheckInterrupt());

        throw new InterruptedException();
    } catch (Throwable var4) {
        this.cancelAcquire(node);
        throw var4;
    }
}
```

```
    private static boolean shouldParkAfterFailedAcquire(Node pred, Node node) {
        int ws = pred.waitStatus;
        //signal状态说明前驱节点正在等待其他线程释放共享资源，也就是处于阻塞状态，直接返回true
        if (ws == Node.SIGNAL)
            /*
             * This node has already set status asking a release
             * to signal it, so it can safely park.
             */
            return true;
        //waitStatus状态大于0表示已经取消了当前节点中的线程任务，跳过这个前驱节点找到前一个前驱节点，将其设置为node的前驱节点
        if (ws > 0) {
            /*
             * Predecessor was cancelled. Skip over predecessors and
             * indicate retry.
             */
            do {
                node.prev = pred = pred.prev;
            } while (pred.waitStatus > 0);
            pred.next = node;
        } else {
        //前驱节点处于0或者PROPAGATE状态，说明需要一个signal信号，但是还没有设置waitStatus
            /*
             * waitStatus must be 0 or PROPAGATE.  Indicate that we
             * need a signal, but don't park yet.  Caller will need to
             * retry to make sure it cannot acquire before parking.
             */
            compareAndSetWaitStatus(pred, ws, Node.SIGNAL);
        }
        return false;
    }
```

###### 节点状态

```
/** waitStatus value to indicate thread has cancelled */
static final int CANCELLED =  1;
/** waitStatus value to indicate successor's thread needs unparking */
static final int SIGNAL    = -1;
/** waitStatus value to indicate thread is waiting on condition */
static final int CONDITION = -2;
/**
 * waitStatus value to indicate the next acquireShared should
 * unconditionally propagate
 */
static final int PROPAGATE = -3;
```



### 共享锁情况

###### doAcquireShared

```
/**
 * Acquires in shared uninterruptible mode.
 * @param arg the acquire argument
 */
private void doAcquireShared(int arg) {
    final Node node = addWaiter(Node.SHARED);
    boolean failed = true;
    try {
        boolean interrupted = false;
        for (;;) {
            final Node p = node.predecessor();
            if (p == head) {
            		//如果前驱节点是头节点，尝试让前驱节点获得共享锁，如果成功，将当前节点设置为头节点
                int r = tryAcquireShared(arg);
                if (r >= 0) {
                    setHeadAndPropagate(node, r);
                    p.next = null; // help GC
                    if (interrupted)
                        selfInterrupt();
                    failed = false;
                    return;
                }
            }
            if (shouldParkAfterFailedAcquire(p, node) &&
                parkAndCheckInterrupt())
                interrupted = true;
        }
    } finally {
        if (failed)
            cancelAcquire(node);
    }
}
```



