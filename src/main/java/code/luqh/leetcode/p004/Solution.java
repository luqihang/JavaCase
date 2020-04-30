package code.luqh.leetcode.p004;

/**
 * @author luqh
 * @date 2019/08/22
 **/
public class Solution {
    public static void main(String[] args) {
//        Solution solution = new Solution();
//        System.out.println(solution.myAtoi("2147483648"));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int len = nums1.length + nums2.length;
        int halfLen = len / 2;
        boolean flag = len % 2 != 0;
        int count = 0;
        int n1 = 0, n2 = 0;
        int halfValue = 0;
        for (; count < halfLen; count++) {
            if (n1 >= nums1.length) {
                halfValue = nums2[n2++];
                continue;
            }
            if (n2 >= nums2.length) {
                halfValue = nums1[n1++];
                continue;
            }
            if (nums1[n1] <= nums2[n2]) {
                halfValue = nums1[n1++];
            } else {
                halfValue = nums2[n2++];
            }
        }

        if (flag) {
            if (n1 >= nums1.length) {
                return nums2[n2++];
            }
            if (n2 >= nums2.length) {
                return nums1[n1++];
            }
            if (nums1[n1] <= nums2[n2]) {
                return nums1[n1];
            } else {
                return nums2[n2];
            }
        } else {
            int nextValue = 0;
            if (n1 >= nums1.length) {
                nextValue = nums2[n2++];
                return (halfValue + nextValue) / 2.0;
            }
            if (n2 >= nums2.length) {
                nextValue = nums1[n1++];
                return (halfValue + nextValue) / 2.0;
            }
            if (nums1[n1] <= nums2[n2]) {
                nextValue = nums1[n1++];
            } else {
                nextValue = nums2[n2++];
            }

            return (halfValue + nextValue) / 2.0;
        }

    }
}
