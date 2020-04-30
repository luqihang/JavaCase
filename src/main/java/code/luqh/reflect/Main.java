package code.luqh.reflect;

import java.lang.reflect.Method;

/**
 * @author luqh
 * @date 2019/11/12
 **/
public class Main {

    public static void main(String[] args) {
        for (Method method : Boy.class.getMethods()) {
            System.out.println(method.getName());
        }
    }
}
