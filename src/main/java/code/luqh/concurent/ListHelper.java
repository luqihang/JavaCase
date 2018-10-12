package code.luqh.concurent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author luqh
 * @date 2018/10/10
 **/
public class ListHelper<E> {
    public List<E> list = Collections.synchronizedList(new ArrayList<E>());

    public synchronized boolean putIfAbsent(E x) {
        System.out.println(Thread.currentThread() + "putIfAbsent begin");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        boolean absent = !list.contains(x);
        if (absent) {
            list.add(x);
        }
        System.out.println(Thread.currentThread() + "putIfAbsent end");

        AtomicInteger a = new AtomicInteger(1);
        return absent;
    }

    public static void main(String[] args) {

        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("关闭");
            }
        });

        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("关闭2");
            }
        });

        new Thread().setDaemon(true);

        System.out.println("啦啦啦");

        System.exit(0);
    }

}
