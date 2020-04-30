package code.luqh.common;

/**
 * @author luqh
 * @date 2020/01/08
 **/
public class IntegerDemo {

    public static void main(String[] args) {
        int a = 0b10000000000000000000000000000000;
        System.out.println(a);

        System.out.printf("%08x\n", Integer.MAX_VALUE);
        System.out.printf("%011o\n", 45646);

        System.out.println(Integer.toBinaryString(500));

        System.out.println(Integer.valueOf(Integer.toBinaryString(500), 2));
    }
}
