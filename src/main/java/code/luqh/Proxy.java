package code.luqh;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 * @author luqh
 * @date 2019/10/21
 **/
public class Proxy {


    private String ts = "test";

    public static Class<Proxy> replace() {
        return Proxy.class;
    }
    public void test(String x) {
        System.out.println(x);
        this.ts = x;
    }

    public String getTs() {
        return ts;
    }

    interface SDKLifespan {
        void onInit();
    }
    static class SDK implements SDKLifespan{
        @Override
        public void onInit() {
            System.out.println("onInit");
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {


        BiConsumer<Proxy, String> test = Proxy::test;

        Proxy proxy = new Proxy();


        Consumer<String> testMethod = proxy::test;

        testMethod.accept("hello");

        System.out.println(proxy.getTs());


//        testMethod.accept("12121");
//
//        FutureTask<String> task = new FutureTask<>(new Callable<String>() {
//            @Override
//            public String call() throws Exception {
//
////                for (int i = 0; i < 5; i++) {
////                    System.out.println(i);
////                    Thread.sleep(1000);
////                }
//
//                FutureTask<Object> task2 = new FutureTask<>(new Callable<Object>() {
//                    @Override
//                    public Object call() throws Exception {
//                        return "sxxx";
//                    }
//                });
//
//                new Thread(task2).start();
//
//                System.out.println(task2.get());
//                return "abc";
//            }
//        });
//
//        new Thread(task).start();
//
//        String s = task.get();
//        System.out.println(s);

//        SDKLifespan sdk = new SDK();
//        SDKLifespan proxy = (SDKLifespan) java.lang.reflect.Proxy.newProxyInstance(SDK.class.getClassLoader(), SDK.class.getInterfaces(), new InvocationHandler() {
//            @Override
//            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                System.out.println("切换主线程");
//                method.invoke(sdk, args);
//                return null;
//            }
//        });
//
////        System.out.println(proxy);
//
//        proxy.onInit();
    }
}
