package code.luqh.zk.lock;

/**
 * @author luqh
 * @date 2018/10/08
 **/
public class ReentrantTest {
    public static class Widget {
        public synchronized void doSomething() {
            System.out.println("Widget...");
        }
    }

    public static class LoggingWidget extends Widget {
        @Override
        public synchronized void doSomething() {
            System.out.println(toString() + ":calling doSomething");
            super.doSomething();
        }
    }

    public static void main(String[] args) {
        new LoggingWidget().doSomething();
    }
}
