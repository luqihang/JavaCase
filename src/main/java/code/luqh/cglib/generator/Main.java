package code.luqh.cglib.generator;

import net.sf.cglib.beans.BeanGenerator;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author luqh
 * @date 2019/10/30
 **/
public class Main {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        BeanGenerator beanGenerator = new BeanGenerator();

        beanGenerator.addProperty("name", String.class);
        Object myBean = beanGenerator.create();

        Method setter = myBean.getClass().getMethod("setName", String.class);
        setter.invoke(myBean, "lalala");

        Method getter = myBean.getClass().getMethod("getName");
        System.out.println(getter.invoke(myBean));
    }
}
