package code.luqh.leetcode.p020;

import java.util.HashMap;
import java.util.Map;

/**
 * @author luqh
 * @date 2019/08/22
 **/
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isValid("{()}"));
    }
    private Map<Character, Character> map = new HashMap<>();
    {
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
    }

    private int index = 0;
    public boolean isValid(String s) {
        index = 0;
        while (index < s.length()) {
            if (!recValid(s, s.charAt(index))) {
                return false;
            }
            index++;
        }
        return true;
    }

    public boolean recValid(String s, char pre) {

        index++;
        if (index >= s.length()) {
            return false;
        }
        char ch = s.charAt(index);
        Character close = map.get(pre);
        if (close == null || ch != close) {
            if (map.get(ch) != null) {
                if (recValid(s, ch)) {
                    return recValid(s, pre);
                } else {
                    return false;
                }
            } else {
                return  false;
            }
        } else {
            return true;
        }
    }
}
