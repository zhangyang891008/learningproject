package zk.lock;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

public class ZKUtil {
    // 通常不同的业务单元会在自己的目录下进行操作
    private static  String address = "192.168.25.102:2181,192.168.25.103:2181,192.168.25.104:2181/lockdir";
    private static CountDownLatch countDownLatch = new CountDownLatch(1);

    public static ZooKeeper getZK() throws IOException, InterruptedException {
        ZooKeeper zk = new ZooKeeper(address, 300, new Watcher() {
            @Override
            public void process(WatchedEvent event) {
                switch (event.getState()) {
                    case Unknown:
                        break;
                    case Disconnected:
                        break;
                    case NoSyncConnected:
                        break;
                    case SyncConnected:
                        System.out.println("syncConnected！。。。");
                        countDownLatch.countDown();
                        break;
                    case AuthFailed:
                        break;
                    case ConnectedReadOnly:
                        break;
                    case SaslAuthenticated:
                        break;
                    case Expired:
                        break;
                }

            }
        });

        countDownLatch.await();
        System.out.println("get zk success!");
        return zk;
    }
}
