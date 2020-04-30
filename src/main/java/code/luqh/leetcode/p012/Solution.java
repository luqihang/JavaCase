package code.luqh.leetcode.p012;


/**
 * @author luqh
 * @date 2019/08/22
 **/
public class Solution {
    private int[] numArr = new int[]{1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
    private String[] romanNumArr = new String[]{"I", "IV", "V", "IX", "X", "XL", "L", "LC", "C", "CD", "D", "DM", "M"};

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.intToRoman(3210));

    }

    public String intToRoman(int num) {

        StringBuilder sb = new StringBuilder(10);
        for(int i = numArr.length - 1; num > 0 && i >= 0; i--) {
            while(num >= numArr[i]) {
                sb.append(romanNumArr[i]);
                num -= numArr[i];
            }
        }
        return sb.toString();
    }

}
