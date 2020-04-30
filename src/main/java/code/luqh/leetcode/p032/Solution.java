package code.luqh.leetcode.p032;


/**
 * @author luqh
 **/
public class Solution {

    public static void main(String[] args) {

        Solution solution = new Solution();
        System.out.println(solution.longestValidParentheses("(()"));
    }

    public int longestValidParentheses(String s) {

        byte[] bytes = s.getBytes();

        int maxCount = 0;
        for (int i = 0; i < bytes.length; i++) {
            int sum = 0;
            int k = i;
            while (k < bytes.length) {
                if (bytes[k] == '(') {
                    sum++;
                } else {
                    sum--;
                }
                if (sum < 0) {
                    break;
                } else if (sum == 0) {
                    System.out.println("-----" + k);
                    if (k - i + 1 > maxCount) {
                        maxCount = k - i + 1;
                    }
                }
                k++;
            }
            if (k == bytes.length) {
                if (sum > 0) {

                }
            }
            i = k;
        }

        return maxCount;
    }

}