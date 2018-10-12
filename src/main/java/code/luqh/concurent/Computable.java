package code.luqh.concurent;

import java.util.concurrent.ExecutionException;

public interface Computable<A, V> {
    V compute(A arg) throws InterruptedException, ExecutionException;
}
