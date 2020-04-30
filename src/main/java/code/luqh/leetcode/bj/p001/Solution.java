package code.luqh.leetcode.bj.p001;

import java.util.BitSet;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @author luqh
 * @date 2018/12/11
 **/
public class Solution {


    public int lengthOfLongestSubstring2(String s) {
        int n = s.length(), ans = 0;
        int[] index = new int[128]; // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        return ans;
    }

    public int lengthOfLongestSubstring(String s) {

        HashMap<Character, Integer> hash = new HashMap<>(128);
        int start = 0;
        int max = 0, count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Integer index = hash.get(c);
            // 为空，继续
            if (index != null) {

                start = Math.max(index, start);
            }
            count++;
            hash.put(c, i);


        }

        return Math.max(max, count);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring("ab"));
    }

}
