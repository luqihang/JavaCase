package code.luqh.leetcode.p020;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author luqh
 * @date 2019/08/22
 **/
public class Solution2 {

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.isValid("{([])}{()}[]"));
    }
    private Map<Character, Character> map = new HashMap<>(4);
    {
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
    }

    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                Character preClose = map.get(stack.peek());
                if (preClose != null && preClose.equals(ch)) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

}
