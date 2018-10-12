package code.luqh;

import java.io.FileInputStream;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author luqh
 * @date 2018/10/11
 **/
public class Single {

    private static volatile Single instance;

    private Single() {

    }

    public static Single getInstance() {

        if (instance == null) {
            synchronized (Single.class) {
                if (instance == null) {
                    System.out.println("创建");
                    instance = new Single();
                }
            }
        }

        return instance;
    }

    public static void main(String[] args) {


        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                Single instance = subSingle.getInstance();
            }
        };

        List<Thread> threads = new ArrayList<>(1000);
        for (int i = 0; i < 10000; i++) {
            threads.add(new Thread(runnable));
        }

        for (Thread thread : threads) {
            thread.start();
        }

    }

    public static class subSingle extends Single {
        private static volatile Single instance;

    }
}
