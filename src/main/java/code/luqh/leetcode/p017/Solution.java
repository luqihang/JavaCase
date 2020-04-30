package code.luqh.leetcode.p017;


import java.util.ArrayList;
import java.util.List;

/**
 * @author luqh
 * @date 2019/08/22
 **/
public class Solution {

    private String[] btnCharArr = new String[]{
            "!@#", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.letterCombinations("23"));

    }

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();
        recLetter(digits, 0, "", result);
        return result;
    }

    private void recLetter(String digits, int index, String oneResult, List<String> result) {
        if (index >= digits.length()) {
            result.add(oneResult);
            return;
        }
        int num = digits.charAt(index) - 48;
        String chars = btnCharArr[num - 1];
        for (int i = 0; i < chars.length(); i++) {
            char c = chars.charAt(i);
            recLetter(digits, index + 1, oneResult + c, result);
        }
    }

}
