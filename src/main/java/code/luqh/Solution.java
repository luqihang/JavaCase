package code.luqh;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author luqh
 * @date 2018/10/10
 **/
public class Solution {

    public static void main(String[] args) {

        System.out.println(new Solution().minFlipsMonoIncr("111011100100100"));
    }

    public int minFlipsMonoIncr(String S) {

        byte[] bytes = S.getBytes();
        boolean flag = false;
        boolean nFlag = false;
        int oneCount = 0;
        int zoreCount = 0;
        int sum = 0;

        for (int i = 0; i < bytes.length; i++) {
            if (flag) {
                if (bytes[i] == '0') {
                    nFlag = true;
                    zoreCount++;
                } else {
                    if (nFlag) {
                        // 计算
                        sum += Math.min(zoreCount, oneCount);
                        oneCount = 0;
                        zoreCount = 0;
                        nFlag = false;
                    }
                    oneCount++;
                }
            } else if (bytes[i] == '1'){
                flag = true;
                nFlag = false;
                oneCount = 1;
                zoreCount = 0;
            }
        }
        sum += Math.min(zoreCount, oneCount);
        return sum;
    }
}
