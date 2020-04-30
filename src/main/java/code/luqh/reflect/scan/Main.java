package code.luqh.reflect.scan;

import java.net.URL;

/**
 * @author luqh
 * @date 2019/10/30
 **/
public class Main {
    public static void main(String[] args) {

        ClassLoader cl = Main.class.getClassLoader();

        URL resource = cl.getResource(".");


    }
}
