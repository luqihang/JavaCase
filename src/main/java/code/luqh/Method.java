package code.luqh;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * @author luqh
 * @date 2019/10/21
 **/
public class Method {


    interface IM {
        String sss(String x);
    }

    public static String strReverse(String str) {
        String result = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            result += str.charAt(i);
        }
        System.out.println(result);
        return result;
    }



    public static String strPrintln(String str) {
        System.out.println(str);
        return str;
    }

    public void test(IM instance, String s) {
        instance.sss(s);
    }


    public static void main(String[] args) {
//        Consumer<Method> test = Method::test;

        List<String> list = Arrays.asList("hhh", "wwww");
        list.stream().map(a -> "" + a).distinct().collect(Collectors.toList());

        new Method().test(Method::strReverse, "1211");
        new Method().test(s -> {
            System.out.println(s);
            return s;
        }, "1211");

    }

}
