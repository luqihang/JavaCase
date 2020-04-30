package code.luqh.leetcode.p015;

import java.util.*;

/**
 * @author luqh
 * @date 2019/08/22
 **/
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }

    public List<List<Integer>> threeSum(int[] nums) {

        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        List<List<Integer>> rs = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int start = i + 1, stop = nums.length - 1;
            while (start < stop) {
                int sum = nums[i] + nums[start] + nums[stop];
                if (sum < 0) {
                    start++;
                } else if (sum > 0) {
                    stop--;
                } else {
                    rs.add(Arrays.asList(nums[i], nums[start], nums[stop]));
                    while (start < stop && nums[start] == nums[start + 1]) {
                        start++;
                    }
                    while (start < stop && nums[stop] == nums[stop - 1]) {
                        stop--;
                    }
                    start++;
                    stop--;
                }
            }
        }
        return rs;
    }
}
