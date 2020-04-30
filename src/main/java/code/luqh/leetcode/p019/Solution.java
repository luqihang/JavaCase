package code.luqh.leetcode.p019;


import code.luqh.leetcode.util.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author luqh
 * @date 2019/08/22
 **/
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode listNode = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        listNode.next = listNode2;
        System.out.println(solution.removeNthFromEnd(listNode, 2).val);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {

        if (head == null) {
            return null;
        }
        ListNode rs = null;
        ListNode toTail = head;
        while (toTail.next != null) {
            toTail = toTail.next;
            if (n > 0) {
                n--;
                if (n == 0) {
                    rs = head;
                }
            } else {
                rs = rs.next;
            }
        }

        if (rs == null) {
            return head.next;
        } else {
            rs.next = rs.next.next;
            return head;
        }
    }

}
