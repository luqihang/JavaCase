package code.luqh.concurent;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Semaphore;

/**
 * @author luqh
 * @date 2018/10/09
 **/
public class SemaphoreCase<T> {


    private final Set<T> set;
    private final Semaphore sem;

    public static void main(String[] args) throws InterruptedException {
        SemaphoreCase<Object> s = new SemaphoreCase<Object>(2);
        Object o1 = new Object();
        Object o2 = new Object();
        Object o3 = new Object();
        try {
            s.add(o1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            s.add(o2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(s.remove(o1));
            }
        }.start();
        try {
            s.add(o3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    public SemaphoreCase(int bound) {
        set = Collections.synchronizedSet(new HashSet<T>());
        sem = new Semaphore(bound);
    }

    public boolean add(T o) throws InterruptedException {
        System.out.println(o);
        sem.acquire();
        System.out.println(o + "添加");
        boolean wasAdded = false;
        try {
            wasAdded = set.add(o);
            return wasAdded;
        } finally {
            if (!wasAdded) {
                sem.release();
            }
        }
    }

    public boolean remove(Object o) {
        System.out.println(o + "释放信号量");
        boolean wasRemoved = set.remove(o);
        if (wasRemoved) {
            sem.release();
        }
        return wasRemoved;
    }
}
