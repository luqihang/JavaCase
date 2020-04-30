package code.luqh.leetcode.p391;

import java.util.ArrayList;
import java.util.List;

/**
 * @author luqh
 * @date 2018/10/24
 **/
class Solution {

    public boolean isRectangleCover(int[][] rectangles) {

        int tspx = Integer.MAX_VALUE, tspy = Integer.MAX_VALUE, tepx = Integer.MIN_VALUE, tepy = Integer.MIN_VALUE;
        int area = 0;
        for (int[] rect : rectangles) {
            int spx = rect[0], spy = rect[1], epx = rect[2], epy = rect[3];
            if (spx <= tspx && spy <= tspy) {
                tspx = spx;
                tspy = spy;
            }
            if (epx >= tepx && epy >= tepy) {
                tepx = epx;
                tepy = epy;
            }
            area += (epx - spx) * (epy - spy);
        }
        int tarea = (tepx - tspx) * (tepy - tspy);
        if (tarea != area) {
            return false;
        }

        // 验证边连续
        int[][] arr = new int[tepx - tspx][tepy - tspy];
        for (int[] rect : rectangles) {
            int spx = rect[0], spy = rect[1], epx = rect[2], epy = rect[3];
            int xL = epx - tspx;
            int yL = epy - tspy;
            for (int i = spx - tspx; i < xL; i++) {
                for (int j = spy - tspy; j < yL; j++) {
                    arr[i][j]++;
                    if (arr[i][j] > 1) {
                        return false;
                    }
                }
            }
        }
        for (int[] ints : arr) {
            for (int anInt : ints) {
                if (anInt != 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isRectangleCover(new int[][]{
                {1, 1, 3, 3},
                {3, 1, 4, 2},
                {3, 2, 4, 4},
                {1, 3, 2, 4},
                {2, 3, 3, 4}
        }));
    }
}
