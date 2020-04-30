package code.luqh.leetcode.p027;


/**
 * @author luqh
 **/
public class Solution {

    public int removeElement(int[] nums, int val) {
        int rsLen = nums.length;
        for(int i = 0; i < rsLen; i++) {
            if (nums[i] == val) {
                while (rsLen > 0 && nums[rsLen - 1] == val) {
                    rsLen--;
                }
                if (i < rsLen) {
                    nums[i] = nums[rsLen - 1];
                    rsLen--;
                }
            }
        }
        return rsLen;
    }
}
