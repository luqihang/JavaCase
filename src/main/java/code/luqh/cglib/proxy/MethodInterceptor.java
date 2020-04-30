package code.luqh.cglib.proxy;

import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author luqh
 * @date 2019/10/29
 **/
public class MethodInterceptor implements net.sf.cglib.proxy.MethodInterceptor {
    @Override
    public Object intercept(Object sub, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        System.out.println("Pre Invoke method");
        Object result = methodProxy.invokeSuper(sub, objects);
        System.out.println("After Invoked method");
        return result;
    }
}
