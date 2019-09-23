package zk.config;

import org.apache.zookeeper.AsyncCallback;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.util.concurrent.CountDownLatch;

public class WatchCallBack implements Watcher, AsyncCallback.StatCallback, AsyncCallback.DataCallback {
    CountDownLatch countDownLatch = new CountDownLatch(1);
    public ZooKeeper zk;
    private MyConf myConf = new MyConf();

    public MyConf getMyConf() {
        return myConf;
    }

    public void setMyConf(MyConf myConf) {
        this.myConf = myConf;
    }

    public ZooKeeper getZk() {
        return zk;
    }

    public void setZk(ZooKeeper zk) {
        this.zk = zk;
    }

    public void await() throws InterruptedException {
        System.out.println("await start...");
            zk.exists("/testConfig",this, (AsyncCallback.StatCallback) this,"abc");
            countDownLatch.await();
        System.out.println("await finish...");
    }

    @Override
    public void process(WatchedEvent event) {
        switch (event.getType()) {
            case None:
                break;
            case NodeCreated:
                zk.getData("/testConfig",this,this,"abc");
                System.out.println("config create!....");
                break;
            case NodeDeleted:
                //根据业务的容忍程度决定。。。
                System.out.println("data delete***....");
                break;
            case NodeDataChanged:
                zk.getData("/testConfig",this,this,"abc");
                System.out.println("config changed!...");
                break;
            case NodeChildrenChanged:
                break;
        }
    }

    @Override
    public void processResult(int rc, String path, Object ctx, Stat stat) {
        if(stat != null){
            //配置存在，配置更新
            System.out.println("node exits! getData ....");
            zk.getData(path,this,this,"abc");
        }
    }

    @Override
    public void processResult(int rc, String path, Object ctx, byte[] data, Stat stat) {
        System.out.println("read data...");
        if(stat != null) {
            System.out.println("set data...");
            String config = new String(data);
            myConf.setConfig(config);
            countDownLatch.countDown();
        }
    }
}
