package code.luqh.leetcode.p190;

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
        int rs = solution.reverseBits(param);
        System.out.println(Integer.toBinaryString(rs));
    }

    public int reverseBits(int n) {
        int rs = 0;
        for (int i = 0; i < 32; i++) {
            rs <<= 1;
            rs += (n & 1);
            n >>>= 1;
        }
        return rs;
    }
}
