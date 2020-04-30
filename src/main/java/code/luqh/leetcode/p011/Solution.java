package code.luqh.leetcode.p011;


/**
 * @author luqh
 * @date 2019/08/22
 **/
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] example = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(solution.maxArea(example));

    }

    public int maxArea(int[] height) {
        int maxArea = 0;
//        for (int i = 0; i < height.length; i++) {
//            for (int j = i + 1; j < height.length; j++) {
//                int area = Math.min(height[i], height[j]) * (j - i);
//                if (area > maxArea) {
//                    maxArea = area;
//                }
//            }
//        }


        for (int i = 0, j = height.length - 1; i < j; ) {
            int area = Math.min(height[i], height[j]) * (j - i);
            if (area > maxArea) {
                maxArea = area;
            }
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return maxArea;
    }

}
