package zk.config;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;

/**
 * 配置中心功能测试：基于ZK的配置中心，统一获取和设置时间
 *
 * @author zhangyang
 * @since 20190923
 */
public class ConfigTest {
    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
        ZooKeeper zk = ZKUtil.getZK();
        WatchCallBack callBack = new WatchCallBack();
        callBack.setZk(zk);
/*
        Stat stat = new Stat();
        byte[] data = zk.getData("/testConfig", false, stat);
        System.out.println("getData:" + new String(data));
*/
        //callBack.await();;
        while(true){

            callBack.await();

            MyConf myConf = callBack.getMyConf();
            System.out.println("CLIENT: read Config:" + myConf.getConfig());
            Thread.sleep(2000);
        }

    }
}
