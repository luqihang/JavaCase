package code.luqh.zk.lock;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.barriers.DistributedBarrier;
import org.apache.curator.framework.recipes.barriers.DistributedDoubleBarrier;
import org.apache.curator.retry.ExponentialBackoffRetry;

import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author luqh
 * @date 2018/10/12
 **/
public class BarrierCase {
    /** zookeeper地址 */
    static final String CONNECT_ADDR = "172.19.10.69:2181";
    /** session超时时间 */
    static final int SESSION_OUTTIME = 5000;//ms



    public static void main(String[] args) throws Exception {


        DistributedBarrier barrier = null;
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 10);
        CuratorFramework cf = CuratorFrameworkFactory.builder()
                .connectString(CONNECT_ADDR)
                .sessionTimeoutMs(SESSION_OUTTIME)
                .retryPolicy(retryPolicy)
                .build();
        cf.start();
        barrier = new DistributedBarrier(cf, "/super");

        for(int i = 0; i < 10; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        DistributedBarrier barrier = null;
                        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 10);
                        CuratorFramework cf = CuratorFrameworkFactory.builder()
                                .connectString(CONNECT_ADDR)
                                .sessionTimeoutMs(SESSION_OUTTIME)
                                .retryPolicy(retryPolicy)
                                .build();

                        cf.start();
                        barrier = new DistributedBarrier(cf, "/super");
                        System.out.println(Thread.currentThread().getName() + "设置barrier!");
                        barrier.setBarrier();   //设置



                        System.out.println("---------开始执行程序----------");
                        Thread.sleep(1000);
//                        barrier.removeBarrier();
                        barrier.waitOnBarrier();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            },"t" + i).start();
        }

        System.out.println("等待");
        barrier.removeBarrier();    //等待
        System.out.println("执行");
        Thread.sleep(5000);

    }
}
