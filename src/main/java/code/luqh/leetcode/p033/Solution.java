package code.luqh.leetcode.p033;


/**
 * @author luqh
 **/
public class Solution {

    public static void main(String[] args) {

        Solution solution = new Solution();
        int[] nums = {1, 3};
        int target = 3;
        System.out.println(solution.search(nums, target));
    }

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        if (target == nums[0]) {
            return 0;
        } else if (target > nums[0]) {
            int i = 0, j = nums.length - 1;
            while (i <= j) {
                int mid = (i + j) / 2;
                if (nums[mid] == target) {
                    return mid;
                } else if(nums[mid] == nums[0]) {
                    i = mid + 1;
                }  else if (nums[mid] < nums[0]) {
                    j = mid - 1;
                } else if (nums[mid] < target) {
                    i = mid + 1;
                } else {
                    j = mid - 1;
                }
            }
        } else {
            int i = 0, j = nums.length - 1;
            while (i <= j) {
                int mid = (i + j) / 2;
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] >= nums[0]) {
                    i = mid + 1;
                } else if (nums[mid] < target) {
                    i = mid + 1;
                } else {
                    j = mid - 1;
                }
            }
        }

        return -1;
    }

}