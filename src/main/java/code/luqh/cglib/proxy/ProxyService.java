package code.luqh.cglib.proxy;

/**
 * @author luqh
 * @date 2019/10/29
 **/
public class ProxyService {

    public ProxyService() {
        System.out.println("构造");
    }

    final public String finalMethod(String str) {
        System.out.println("finalMethod:" + str);
        return null;
    }

    public void method() {
        System.out.println("common void method");
    }
}
