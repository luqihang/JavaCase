package code.luqh.concurent;

import sun.misc.Unsafe;
import sun.reflect.Reflection;

import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author luqh
 * @date 2018/10/16
 **/
public class UnsafeCase {

    static class X {
        private volatile long a;
        private volatile long b;
        private volatile long c;
    }

    static class Y {
        private volatile long a;
    }

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {


        AtomicInteger ai = new AtomicInteger(10);
        System.out.println(ai.getAndUpdate(a -> a + 1));
        System.out.println(ai.get());

        System.out.println(ai.accumulateAndGet(5, (l, r) -> l * r + 1));
        Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
        theUnsafe.setAccessible(true);

        Unsafe unsafe = (Unsafe) theUnsafe.get(null);

        X o = new X();

        long offset = unsafe.objectFieldOffset(X.class.getDeclaredField("a"));
        System.out.println(offset);
        System.out.println(unsafe.objectFieldOffset(X.class.getDeclaredField("b")));
        System.out.println(unsafe.objectFieldOffset(X.class.getDeclaredField("c")));
        System.out.println(unsafe.compareAndSwapInt(o, offset, 0, 2));

        System.out.println(unsafe.compareAndSwapInt(o, offset, 2, 3));

        System.out.println(o.a);

    }
}
