package code.luqh.leetcode.p022;


import code.luqh.leetcode.util.ListNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author luqh
 * @date 2019/08/22
 **/
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    public List<String> generateParenthesis(int n) {

        List<String> res = new ArrayList<String>();
        generate(res, "", 0, 0, n);

        return res;
    }

    public void generate(List<String> res, String ans, int count1, int count2, int n) {
        if (count1 > n || count2 > n) {
            return;
        }
        if (count1 == n && count2 == n) {
            res.add(ans);
            return;
        }
        if (count1 >= count2) {
            generate(res, ans + "(", count1 + 1, count2, n);
            generate(res, ans + ")", count1, count2 + 1, n);
        }
    }
}
