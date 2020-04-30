package code.luqh.leetcode.p031;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

/**
 * @author luqh
 **/
public class Solution {

    public static void main(String[] args) {

        Solution solution = new Solution();
        int[] nums = {1, 3, 2};
        solution.nextPermutation(nums);
        for (int num : nums) {
            System.out.println(num);
        }

    }


    public void nextPermutation(int[] nums) {

        if (nums.length <= 1) {
            return;
        }
        int i = nums.length - 1;
        for (; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                int j = nums.length - 1;
                for (; j > i; j--) {
                    if (nums[j] > nums[i - 1]) {
                        break;
                    }
                }
                // 交换
                int temp = nums[i - 1];
                nums[i - 1] = nums[j];
                nums[j] = temp;
                Arrays.sort(nums, i, nums.length);
                break;
            }
        }
        if (i == 0) {
            Arrays.sort(nums);
        }
    }

}