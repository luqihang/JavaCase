package code.luqh.classloader;

import java.util.HashMap;

/**
 * @author luqh
 * @date 2019/11/01
 **/
public class Test {

    public static void main(String[] args) {
        Bean build = Bean.builder().field("111").value1("1211").build();
        build.test();
    }
}
