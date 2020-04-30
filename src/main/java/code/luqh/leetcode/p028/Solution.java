package code.luqh.leetcode.p028;


/**
 * @author luqh
 **/
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.strStr("a", "a"));
    }

    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) {
            return -1;
        }
        if (haystack.length() == 0 && needle.length() == 0) {
            return 0;
        }
        if (needle.length() == 0) {
            return -1;
        }
        int endIndex = haystack.length() - needle.length();
        if (endIndex < 0) {
            return -1;
        }

        loop1:
        for (int i = 0; i <= endIndex; i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                int j = 1;
                for (; j < needle.length(); j++) {
                    if (haystack.charAt(i + j) != needle.charAt(j)) {
                        continue loop1;
                    }
                }
                if (j == endIndex) {
                    return i;
                }
            }
        }
        return -1;
    }


    public int strStr2(String haystack, String needle) {
        if ("".equals(needle) || needle == null) return 0;
        return haystack.indexOf(needle);
    }
}
