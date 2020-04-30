package code.luqh;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author luqh
 * @date 2019/10/12
 **/
public class Test {


    static class A {

    }

    static class B extends A{


    }

    static class C {
        public void t(A a) {

            System.out.println("test");
            System.out.println(a.getClass());
        }
    }

    interface IA<T extends A> {
        T test(T a);
    }

    interface IB extends IA<B>{
    }

    class D implements IB{

        @Override
        public B test(B a) {
            return null;
        }
    }

    class F implements IA {

        @Override
        public A test(A a) {
            return null;
        }
    }



    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {


//        AbstractParam.test();
//        B b = new B();
//        A ba = b;
//
//        C c = new C();
//        System.out.println(IA.class.isAssignableFrom(b.getClass()));

//        Method t = c.getClass().getDeclaredMethod("t", b.getClass());
//
//        System.out.println(t);
//
//        System.out.println(A.class.cast(b));
//
//        t.invoke(c, A.class.cast(b));
//
//        System.out.println(ba.getClass());

    }
}
