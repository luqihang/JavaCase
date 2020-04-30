package code.luqh.leetcode.p008;

/**
 * @author luqh
 * @date 2019/08/22
 **/
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.myAtoi("2147483648"));
    }
    public int myAtoi(String str) {
        int rs = 0;
        boolean numFlag = false;
        boolean negFlag = false;
        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (numFlag) {
                if (ch >= '0' && ch <= '9') {
                    int newRS = rs * 10 + (ch - '0');
                    if ((newRS - (ch - '0')) / 10 != rs) {
                        return negFlag ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                    } else {
                        rs = newRS;
                    }
                } else {
                    break;
                }
            } else {
                if (ch == ' ') {
                    continue;
                } else if(!negFlag && str.charAt(i) == '-') {
                    negFlag = true;
                    numFlag = true;
                } else if(str.charAt(i) == '+') {
                    negFlag = false;
                    numFlag = true;
                } else if(ch >= '0' && ch <= '9'){
                    numFlag = true;
                    i--;
                } else {
                    return 0;
                }
            }
        }

        if (negFlag) {
            if (-rs > 0) {
                return Integer.MIN_VALUE;
            }
        } else {
            if (rs < 0) {
                return Integer.MAX_VALUE;
            }
        }
        return negFlag ? -rs : rs;
    }
}
