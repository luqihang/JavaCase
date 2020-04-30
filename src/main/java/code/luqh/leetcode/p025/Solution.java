package code.luqh.leetcode.p025;


import code.luqh.leetcode.util.ListNode;

/**
 * @author luqh
 **/
public class Solution {

    public static void main(String[] args) {

        Solution solution = new Solution();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        solution.reverseKGroup(l1, 2);
    }

// 使用额外空间解法
//    private ListNode[] nodeList = null;
//    public ListNode reverseKGroup(ListNode head, int k) {
//        nodeList = new ListNode[k];
//        return reverseKGroupBackup(head, k);
//    }
//
//    public ListNode reverseKGroupBackup(ListNode head, int k) {
//
//        ListNode p = head;
//        for(int i = 0; i < k; i++,p = p.next) {
//            if (p == null) {
//                return head;
//            }
//        }
//        ListNode nextGroup = reverseKGroupBackup(p, k);
//
//        p = head;
//        for(int i = 0; i < k; i++, p = p.next) {
//            nodeList[i] = p;
//        }
//
//        for(int i = k - 1; i > 0 ; i--) {
//            nodeList[i].next = nodeList[i - 1];
//        }
//
//        nodeList[0].next = nextGroup;
//
//        return nodeList[k - 1];
//
//    }

    /**
     * 不使用额外空间解法
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode p = head;
        for(int i = 0; i < k; i++,p = p.next) {
            if (p == null) {
                return head;
            }
        }
        ListNode pre = head;
        ListNode next = pre.next;
        for(int i = 0; i < k - 1; i++) {
            ListNode temp = next.next;
            next.next = pre;
            pre = next;
            next = temp;
        }
        head.next = reverseKGroup(p, k);
        return pre;
    }
}
