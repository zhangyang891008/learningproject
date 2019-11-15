## Semaphore

#### NonFair

###### nonfairTryAcquireShared

```
final int nonfairTryAcquireShared(int acquires) {
    for (;;) {
    		//首先获取状态信息
        int available = getState();
        //计算如果加锁成功后的状态信息
        int remaining = available - acquires;
        //如果计算结果小于零，说明资源不够加锁，直接返回负数表示加锁失败；
        //否则尝试修改状态
        if (remaining < 0 ||
            compareAndSetState(available, remaining))
            return remaining;
    }
}
```



#### Fair

###### tryAcquireShared

```
protected int tryAcquireShared(int acquires) {
    for (;;) {
    		先检查是否有排队的线程
        if (hasQueuedPredecessors())
            return -1;
        下面的流程跟非公平锁相同
        int available = getState();
        int remaining = available - acquires;
        if (remaining < 0 ||
            compareAndSetState(available, remaining))
            return remaining;
    }
}
```











