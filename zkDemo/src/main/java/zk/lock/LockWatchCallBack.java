package zk.lock;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;
import sun.java2d.SurfaceDataProxy;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class LockWatchCallBack implements AsyncCallback.StringCallback, AsyncCallback.Children2Callback, AsyncCallback.StatCallback, Watcher {

    CountDownLatch countDownLatch = new CountDownLatch(1);
    private ZooKeeper zk;

    String myThread ; //保存当前线程名，方便观察日志
    String pathName; //保存当前线程创建的临时有序节点的名称；

    public String getMyThread() {
        return myThread;
    }

    public void setMyThread(String myThread) {
        this.myThread = myThread;
    }

    public void setZK(ZooKeeper zk) {
        this.zk = zk;
    }

    public void tryLock() throws InterruptedException {
        //创建节点
        zk.create("/lock",myThread.getBytes(),ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.EPHEMERAL_SEQUENTIAL,this,"abc");
        countDownLatch.await();
    }

    public void unLock() throws KeeperException, InterruptedException {
        zk.delete(pathName,-1);
        System.out.println(myThread+"  unlock...");
    }

    @Override
    public void processResult(int rc, String path, Object ctx, String name) {
        pathName = name;
        System.out.println(myThread+"---"+pathName);
        zk.getChildren("/",false,this,"abc");
    }

    @Override
    public void processResult(int rc, String path, Object ctx, List<String> children, Stat stat) {
        /*
        System.out.println("path:" + path);
        for (int i = 0; i < children.size(); i++) {
            System.out.println(children.get(i));
        }
        */
        Collections.sort(children);
        int index = children.indexOf(pathName.substring(1));
        if(index == 0){

            try {
                System.out.println("current:"+path);
                //避免当前线程获得锁以后消费太快，导致后面的线程无法watch的问题，同时可以作为重入锁的判断依据，相同线程只需要加锁一次。
                Stat stats = zk.setData(pathName, ("reentrant:" + myThread).getBytes(), -1);
                System.out.println(stats.getCtime());
            } catch (KeeperException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            countDownLatch.countDown();
            System.out.println("我是"+myThread+"--"+pathName);
        }else{
           // System.out.println("watching...");
            zk.exists("/"+children.get(index-1),this,this,"abc");
            System.out.println(myThread+" watching " + children.get(index-1));
        }

    }

    @Override
    public void processResult(int rc, String path, Object ctx, Stat stat) {
        if(stat == null){
            System.out.println("watch failed!");
        }
    }

    @Override
    public void process(WatchedEvent event) {
        switch (event.getType()) {
            case None:
                break;
            case NodeCreated:
                break;
            case NodeDeleted:
                //System.out.println("前一个节点已经删除，可以抢占。。。")
                zk.getChildren("/",false,this,"abc");
                break;
            case NodeDataChanged:
                break;
            case NodeChildrenChanged:
                break;
        }
    }
}
