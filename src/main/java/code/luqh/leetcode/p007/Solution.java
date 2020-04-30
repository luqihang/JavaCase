package code.luqh.leetcode.p007;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author luqh
 * @date 2019/08/22
 **/
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverse(-321));
    }

    public int reverse(int x) {
        int rpc = 0;
        while (x != 0) {
            int newrpc = rpc * 10 + x % 10;
            if ((newrpc - x % 10) / 10 != rpc) {
                return 0;
            }
            rpc = newrpc;
            x = x / 10;
        }
        return rpc;
    }
}
