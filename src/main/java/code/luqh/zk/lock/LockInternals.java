package code.luqh.zk.lock;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author luqh
 * @date 2018/09/30
 **/
public class LockInternals {
    private String lockPath;
    private String lockName;

    private ZooKeeper zk;

    public LockInternals(ZooKeeper zk, String lockPath, String lockName) {
        this.zk = zk;
        this.lockPath = lockPath;
        this.lockName = lockName;
    }

    private final Watcher watcher = new Watcher()
    {
        @Override
        public void process(WatchedEvent event)
        {
            System.out.println(event.getType() + event.getPath());
            notifyFromWatcher();
        }
    };

    private synchronized void notifyFromWatcher() {
        notifyAll();
    }

    private String fixSeq(String path) {

        int index = path.lastIndexOf(lockName);
        if (index > 0) {
            index += lockName.length();
            return index <= path.length() ? path.substring(index) : "";
        }
        return path;
    }

    public void lookLoop(String currentPath) throws KeeperException, InterruptedException {

        boolean hasLock = false;
        boolean needDelete = false;

        try {
            while (!hasLock) {

                System.out.println(Thread.currentThread().getName() + "检测锁状态");
                String seqName = currentPath.substring(lockPath.length() + 1);
                List<String> children = zk.getChildren(lockPath, true);
                Collections.sort(children, new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        return fixSeq(o1).compareTo(fixSeq(o2));
                    }
                });

                int index = children.indexOf(seqName);
                if (index == 0) {
                    hasLock = true;
                } else {
                    String preSeqName = children.get(index - 1);
                    System.out.println(Thread.currentThread().getName() + "监听" + preSeqName);
                    synchronized (this) {
                        zk.getData(lockPath + "/" + preSeqName, watcher, null);

                        System.out.println(Thread.currentThread().getName() + "wait获取时间片");
                        wait();
                        System.out.println(Thread.currentThread().getName() + "获取时间片");
                    }
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
            needDelete = true;
            throw e;
        } finally {
            if (needDelete) {
                zk.delete(currentPath, -1);
            }
        }
    }

}
