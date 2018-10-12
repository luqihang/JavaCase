package code.luqh.concurent;

import java.util.concurrent.CountDownLatch;

/**
 * @author luqh
 * @date 2018/10/09
 **/
public class CountDownLatchCase {

    public static void main(String[] args) throws InterruptedException {

        System.out.println(new CountDownLatchCase().timeTasks(10, new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName() + "|结束");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }));
    }

    public long timeTasks(int nThreads, final Runnable task) throws InterruptedException {
        final CountDownLatch startGate = new CountDownLatch(1);
        final CountDownLatch endGate = new CountDownLatch(nThreads);

        for (int i = 0; i < nThreads; i++) {
            Thread t = new Thread() {
                @Override
                public void run() {
                    try {
                        startGate.await();

                        try {
                            task.run();
                        } finally {
                            endGate.countDown();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            t.start();
        }

        long start = System.nanoTime();
        startGate.countDown();
        System.out.println("startGate");
        endGate.await();
        long end = System.nanoTime();

        System.out.println("lalala");
        System.out.println("2222");
        return end - start;

       
    }
}
