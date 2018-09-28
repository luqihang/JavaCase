package code.luqh.zk.lock;


import com.google.common.collect.Lists;
import org.apache.zookeeper.*;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

public class DistributeLock {

    public static void main(String[] args) throws InterruptedException, IOException, KeeperException {

        ZooKeeper zk = new ZooKeeper("localhost:32770", 3000, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {

                System.out.println(watchedEvent.getState());

            }
        });

        List<String> children = zk.getChildren("/", true);
        for (String child : children) {
            System.out.println(child);
        }



//        zk.create("/test", "locks".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
//        zk.create("/test/locks", "locks".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);


        for (int i = 0; i < 100; i++) {
            zk.create("/test/locks/"+ UUID.randomUUID().toString() + "_lock_", "data".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
        }


        Thread.sleep(10000);

        zk.close();

    }


}
