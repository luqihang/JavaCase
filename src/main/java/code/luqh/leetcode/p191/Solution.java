package code.luqh.leetcode.p191;

/**
 * @author luqh
 * @date 2019/08/22
 **/
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int param = Integer.valueOf("00000010100101000001111010011100", 2);
        System.out.println(param);
        System.out.println(Integer.toBinaryString(param));
        int rs = solution.hammingWeight(param);
        System.out.println(rs);
        System.out.println(Integer.toBinaryString(rs));
    }

    public int hammingWeight(int n) {

        int i = n;
        System.out.println(Integer.toBinaryString(i));
        i = (i & 0x55555555) + ((i >>> 1) & 0x55555555);
        System.out.println(Integer.toBinaryString(i));
        i = (i & 0x33333333) + ((i >>> 2) & 0x33333333);
        System.out.println(Integer.toBinaryString(i));
        i = (i + (i >>> 4)) & 0x0f0f0f0f;
        i = i + (i >>> 8);
        i = i + (i >>> 16);
        return i & 0x3f;
//        return Integer.bitCount(n);
//        int count = 0;
//        while (n != 0) {
//            count += n & 1;
//            n >>>= 1;
//        }
//        return count;
    }
}
