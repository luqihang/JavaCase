package code.luqh.leetcode.p038;

import code.luqh.leetcode.util.ListNode;

/**
 * @author luqh
 * @date 2019/08/22
 **/
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    public String countAndSay(int n) {
        StringBuilder lastSb = new StringBuilder("1");
        for(int i = 0; i < n; i++) {
            String temp = lastSb.toString();
            lastSb.delete(0, lastSb.length());
            char lastCh = temp.charAt(0);
            int count = 0;
            for(int j = 0; j < temp.length(); j++) {
                if (temp.charAt(j) == lastCh) {
                    count++;
                } else {
                    lastSb.append(count).append(lastCh);
                    lastCh = temp.charAt(j);
                    count = 1;
                }
            }
            lastSb.append(count).append(lastCh);
        }
        return lastSb.toString();
    }
}
