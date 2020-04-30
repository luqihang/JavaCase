package code.luqh.javassist.proxy;

import javassist.util.proxy.MethodHandler;
import javassist.util.proxy.ProxyFactory;
import javassist.util.proxy.ProxyObject;

import java.lang.reflect.Method;

/**
 * @author luqh
 * @date 2019/10/30
 **/
public class Main {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {

        ProxyFactory proxyFactory = new ProxyFactory();

        proxyFactory.setSuperclass(PersonService.class);

        Class<?> proxyClass = proxyFactory.createClass();

        PersonService proxyObject = (PersonService) proxyClass.newInstance();

        ((ProxyObject) proxyObject).setHandler(new MethodHandler() {
            PersonService instance = new PersonService();
            @Override
            public Object invoke(Object o, Method method, Method method1, Object[] objects) throws Throwable {
                System.out.println("before");

                Object rs = method.invoke(instance, objects);
                System.out.println("after");
                return rs;
            }
        });

        proxyObject.personFly();

    }
}
