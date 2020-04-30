package code.luqh.leetcode.p016;


import java.util.Arrays;

/**
 * @author luqh
 * @date 2019/08/22
 **/
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] example = new int[]{1, 1, -1, -1, 3};
        System.out.println(solution.threeSumClosest(example, -1));

    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int NV = nums[0] + nums[1] + nums[2];
        for (int s = 0; s <= nums.length + 2; s++) {
            int m = s + 1, e = nums.length - 1;
            while (m < e) {
                int sum = nums[s] + nums[m] + nums[e];
                if (Math.abs(sum - target) < Math.abs(NV - target)) {
                    NV = sum;
                }
                if (NV < target) {
                    m++;
                } else if (NV > target) {
                    e--;
                } else {
                    return NV;
                }
            }
        }

        return NV;
    }

}
