package zk.lock;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;

/**
 * 分布式索功能测试：模拟10个线程枪锁，基于ZK的Sequence+临时节点，实现队列的分布式锁，每个节点watch前面一个节点的状态，可以避免ZK服务器的抢锁压力、保证实时性。
 *
 * @author zhangyang
 * @since 20190923
 */
public class LockTest {

    public static void main(String[] args) throws IOException, InterruptedException {

        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    //获得连接
                    ZooKeeper zk = null;
                    try {
                        zk = ZKUtil.getZK();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    LockWatchCallBack callBack = new LockWatchCallBack();
                    callBack.setZK(zk);
                    callBack.setMyThread(Thread.currentThread().getName());

                    //加锁
                    try {
                        callBack.tryLock();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    //干活
                    System.out.println(Thread.currentThread().getName()+"=="+"working...");
                    try {
                        //为了避免消费太快，后面的节点来不及watch，所以睡眠一段时间
                        Thread.sleep(1000000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    //解锁
                    try {
                        callBack.unLock();
                    } catch (KeeperException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

    }
}
