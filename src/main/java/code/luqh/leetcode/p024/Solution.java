package code.luqh.leetcode.p024;


import code.luqh.leetcode.util.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author luqh
 **/
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    public ListNode swapPairs2(ListNode head) {

        ListNode h = new ListNode(0);
        h.next = head;
        ListNode p = h;

        while (p != null) {
            if (p.next == null || p.next.next == null) {
                return h.next;
            }
            ListNode t1 = p.next;
            ListNode t2 = t1.next;
            ListNode t3 = t2.next;
            p.next = t2;
            t2.next = t1;
            t1.next = t3;
            p = p.next.next;
        }

        return h.next;

    }

    public ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp = head.next;
        head.next = swapPairs(temp.next);
        temp.next = head;
        return temp;

    }
}
