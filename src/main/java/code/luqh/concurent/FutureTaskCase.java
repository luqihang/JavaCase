package code.luqh.concurent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author luqh
 * @date 2018/10/09
 **/
public class FutureTaskCase {

    private final FutureTask<Object> future = new FutureTask<Object>(new Callable<Object>() {
        @Override
        public Object call() throws Exception {
            System.out.println("call back");
            Thread.sleep(1000);
            return new Object();
        }
    });

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTaskCase futureTaskCase = new FutureTaskCase();
        futureTaskCase.start();

        System.out.println(futureTaskCase.get());

    }

    private final Thread thread = new Thread(future);

    public void start() {
        thread.start();
    }

    public Object get() throws InterruptedException, ExecutionException {

        return future.get();

    }

}
