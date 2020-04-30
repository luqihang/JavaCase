package code.luqh.cglib.proxy;

import net.sf.cglib.proxy.Enhancer;

import java.lang.reflect.InvocationTargetException;

/**
 * @author luqh
 * @date 2019/10/29
 **/
public class Main {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(ProxyService.class);
        enhancer.setCallback(new MethodInterceptor());

        ProxyService proxyService = (ProxyService) enhancer.create();

        proxyService.method();

        proxyService.finalMethod("=.=");


    }
}
