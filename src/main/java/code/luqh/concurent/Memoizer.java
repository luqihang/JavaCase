package code.luqh.concurent;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

/**
 * @author luqh
 * @date 2018/10/09
 **/
public class Memoizer<A, V> implements Computable<A, V> {

    private final Map<A, Future<V>> cache = new ConcurrentHashMap<>();
    private final Computable<A, V> c;

    public Memoizer(Computable<A, V> c) {
        this.c = c;
    }

    @Override
    public V compute(final A arg) throws InterruptedException {
        while (true) {
            Future<V> result = cache.get(arg);
            if (result == null) {
                Callable<V> eval = new Callable<V>() {
                    @Override
                    public V call() throws Exception {
                        return c.compute(arg);
                    }
                };
                FutureTask<V> ft = new FutureTask<>(eval);
                System.out.println("设置缓存");
                result = cache.putIfAbsent(arg, ft);
                if (result == null) {
                    System.out.println("设置缓存22S");
                    result = ft;
                    ft.run();
                }
            }
            try {
                return result.get();
            } catch (CancellationException e) {

                System.out.println("remove");
                cache.remove(arg, result);
            } catch (ExecutionException e) {
                e.printStackTrace();
                throw new RuntimeException("111");
            }

            System.out.println("while");
        }
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExpensiveFunction expensiveFunction = new ExpensiveFunction();
        Memoizer<String, BigInteger> memoizer = new Memoizer<>(expensiveFunction);

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(memoizer.compute("1"));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        for (int i = 0; i < 1000; i++) {
            new Thread(runnable).start();
        }
    }

}

class ExpensiveFunction implements Computable<String, BigInteger> {

    @Override
    public BigInteger compute(String arg) throws InterruptedException {
        System.out.println("计算");
        return new BigInteger(arg);
    }
}