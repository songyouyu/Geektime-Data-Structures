package chapter6;

/**
 * 合并两个有序链表
 *
 * @author youyu.song
 * @date 2020/9/4 20:40
 */
public class Leetcode21 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(-1);
        ListNode head1 = l1;
        ListNode head2 = l2;
        ListNode p = dummyNode;

        while (head1 != null && head2 != null) {
            if (head1.val <= head2.val) {
                p.next = head1;
                head1 = head1.next;
            } else {
                p.next = head2;
                head2 = head2.next;
            }
            p = p.next;
        }

        if (head1 != null) {
            p.next = head1;
        }
        if (head2 != null) {
            p.next = head2;
        }

        return dummyNode.next;

    }


}
