package code.luqh.leetcode.p023;


import code.luqh.leetcode.util.ListNode;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @author luqh
 * <p>
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 * <p>
 * 输入:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 **/
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();

        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;

        ListNode l11 = new ListNode(1);
        ListNode l12 = new ListNode(3);
        ListNode l13 = new ListNode(4);
        l11.next = l12;
        l12.next = l13;

        ListNode l21 = new ListNode(2);
        ListNode l22 = new ListNode(6);
        l21.next = l22;

        ListNode[] listNodes = {l1, l11, l21};
        solution.mergeKLists(listNodes);

    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        if (lists.length == 2) {
            return mergeTwo(lists[0], lists[1]);
        }
        int mid = lists.length / 2;
        ListNode[] l1 = new ListNode[mid];
        ListNode[] l2 = new ListNode[lists.length - mid];
        for (int i = 0; i < mid; i++) {
            l1[i] = lists[i];
        }
        for (int i = mid; i < lists.length; i++) {
            l2[i - mid] = lists[i];
        }
        return mergeTwo(mergeKLists(l1), mergeKLists(l2));
    }

    public ListNode mergeTwo(ListNode h1, ListNode h2) {
        if (h1 == null) {
            return h2;
        }
        if (h2 == null) {
            return h1;
        }
        ListNode head = null;
        if (h1.val < h2.val) {
            head = h1;
            h1 = h1.next;
        } else {
            head = h2;
            h2 = h2.next;
        }
        ListNode point = head;
        while (h1 != null && h2 != null) {
            if (h1.val < h2.val) {
                point.next = h1;
                point = h1;
                h1 = h1.next;
            } else {
                point.next = h2;
                point = h2;
                h2 = h2.next;
            }
        }
        if (h1 != null) {
            point.next = h1;
        }
        if (h2 != null) {
            point.next = h2;
        }
        return head;
    }
}
