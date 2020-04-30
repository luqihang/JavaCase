package code.luqh.leetcode.p029;


/**
 * @author luqh
 **/
public class Solution {

    public static int NO_SIGN = 0x7FFFFFFF;

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(Integer.toBinaryString(3));
        System.out.println(Integer.toBinaryString(-3));
        System.out.println(Integer.toBinaryString((-3 ^ 0xFFFFFFFF) + 1));

        System.out.println(Integer.toBinaryString(4));
        System.out.println(Integer.toBinaryString((-4 ^ 0xFFFFFFFF) + 1));
        System.out.println(Integer.toBinaryString(-300 >>> 1));
        System.out.println(Integer.toBinaryString(-300 >>> 2));

        System.out.println(Integer.toBinaryString(Integer.MIN_VALUE));
        System.out.println(Integer.toBinaryString((Integer.MIN_VALUE ^ 0xFFFFFFFF) + 1));

//        System.out.println(solution.divide(-3, 2));

    }
// 1: 3| 1 < 11
// 2: 2| 11 >= 11 1101 - 11 << 2  rs += 1 >> 2   0001
// 3: 1| 10 >0 10 0101 - 10 << 1 rs + 10 0001
// 4: 0| 0 < 10
//    100


    public int divide(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }
        if (divisor == 1) {
            return dividend;
        }
        if (divisor == -1) {
            if (dividend == Integer.MIN_VALUE) {
                return Integer.MAX_VALUE;
            }
            return -dividend;
        }


        boolean negative = (dividend ^ divisor) < 0;


        int rs = 0;
        for (int i = 31; i >= 0; i--) {
//            System.out.println(Integer.toBinaryString(i));
            if ((dividend >>> i) >= divisor) {
                System.out.println("------");
                System.out.println(dividend);
                System.out.println(dividend >>> i);
                System.out.println(i);
//                dividend -=(divisor << i);

                System.out.println(1 << i);
                rs += (1 << i);
            }
        }

        return rs;
    }
}