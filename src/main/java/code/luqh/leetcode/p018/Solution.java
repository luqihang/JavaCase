package code.luqh.leetcode.p018;


import java.util.*;

/**
 * @author luqh
 * @date 2019/08/22
 **/
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();

        List<List<Integer>> lists = solution.fourSum(new int[]{-3, -2, -1, 0, 0, 1, 2, 3}, 0);
        System.out.println(lists);
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> rs = new ArrayList<>();
        int len = nums.length;
        if (len == 0 || len < 4) {
            return rs;
        }
        Arrays.sort(nums);
        for (int p0 = 0; p0 < len - 3; p0++) {
            if (nums[p0] + nums[p0 + 1] + nums[p0 + 2] + nums[p0 + 3] > target) {
                break;
            }
            if (nums[p0] + nums[len - 3] + nums[len - 2] + nums[len - 1] < target) {
                continue;
            }
            for (int p1 = p0 + 1; p1 < len - 2; p1++) {
                if (nums[p0] + nums[p1] + nums[p1 + 1] + nums[p1 + 2] > target) {
                    break;
                }
                if (nums[p0] + nums[p1] + nums[len - 2] + nums[len - 1] < target) {
                    continue;
                }
                int p2 = p1 + 1, p3 = len - 1;
                while (p2 < p3) {
                    int sum = nums[p0] + nums[p1] + nums[p2] + nums[p3];

                    if (sum > target) {
                        p3--;
                    } else if (sum < target) {
                        p2++;
                    } else {
                        rs.add(Arrays.asList(nums[p0], nums[p1], nums[p2], nums[p3]));
                        while (p2 < p3 && nums[p2] == nums[p2 + 1]) {
                            p2++;
                        }
                        while (p2 < p3 && nums[p3] == nums[p3 - 1]) {
                            p3--;
                        }
                        p2++;
                        p3--;
                    }
                }
                while (p1 < len - 2 && nums[p1] == nums[p1 + 1]) {
                    p1++;
                }
            }
            while (p0 < len - 3 && nums[p0] == nums[p0 + 1]) {
                p0++;
            }
        }

        return rs;
    }

}
