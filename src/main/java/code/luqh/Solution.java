package code.luqh;

import java.util.concurrent.Executors;

/**
 * @author luqh
 * @date 2018/10/10
 **/
public class Solution {

    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());


        new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {

            }
        };
    }
}
