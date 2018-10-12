package code.luqh.concurent.thread;

import java.util.*;

/**
 * @author luqh
 * @date 2018/09/21
 **/
public class ThreadLocalCase {
    public ThreadLocalCase() {
        System.out.println("333333");
    }

    {
        System.out.println(222);
    }



    static  {

        System.out.println("111");
    }

    private static final ThreadLocal<Object> threadLocal = new ThreadLocal<Object>();

    public static void main(String[] args) {

        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < 100; i++) {
            map.put(i, i);
        }
        map = Collections.synchronizedMap(map);

        Map<Integer, Integer> finalMap = map;
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (Map.Entry<Integer, Integer> entry : finalMap.entrySet()) {
                    System.out.println(entry);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                for (Map.Entry<Integer, Integer> entry : finalMap.entrySet()) {
                    System.out.println(entry);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    public static class Task implements Runnable {

        @Override
        public void run() {
            while (true) {
                System.out.println("xxxxx");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
