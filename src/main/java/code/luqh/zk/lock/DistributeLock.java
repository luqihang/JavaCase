package code.luqh.zk.lock;


import com.google.common.collect.Lists;
import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DistributeLock implements Lock {

    private ZooKeeper zk;
    private String lockPath;
    private String lockName = "_lock_";
    private String ourPath = null;

    private LockInternals lockInternals;



    public DistributeLock(ZooKeeper zk, String lockPath) {
        this.zk = zk;
        this.lockPath = lockPath;
        this.lockInternals = new LockInternals(zk, lockPath, lockName);
    }

    public static void main(String[] args) throws InterruptedException, IOException, KeeperException {


        String config = "172.19.10.69:2181";
//        String config = "localhost:32770";
        ZooKeeper zk = new ZooKeeper(config, 3000, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {

                System.out.println(watchedEvent.getState());

            }
        });

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                String threadName = Thread.currentThread().getName();

                DistributeLock lock = new DistributeLock(zk, "/locks");
                try {
                    lock.lock();
                    System.out.println(System.currentTimeMillis());
                    System.out.println(threadName + "获取锁");
                    System.out.println(threadName + "正在执行业务");
                    Thread.sleep(5000);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    System.out.println(threadName + "释放锁");
                    lock.unlock();
                }


            }
        };

        List<Thread> threadList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Thread thread = new Thread(runnable);
            thread.start();
            threadList.add(thread);
        }

        for (Thread thread : threadList) {
            thread.join();
        }


        Thread.sleep(10000);
        zk.close();

    }


    @Override
    public void lock() {

        boolean isDone = false;

        while (!isDone) {
            isDone = true;

            try {
                System.out.println("创建锁文件");
                ourPath = zk.create(lockPath + "/_lock_", new byte[0], ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
                System.out.println("锁文件" + Thread.currentThread().getName() + ":" + ourPath);
                lockInternals.lookLoop(ourPath);
            } catch (KeeperException e) {
                e.printStackTrace();
                isDone = false;
            } catch (InterruptedException e) {
                e.printStackTrace();
                isDone = false;
            }
        }
    }








    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {


        return false;
    }

    @Override
    public void unlock() {

        try {
            zk.delete(ourPath, -1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Condition newCondition() {
        return null;
    }

}
