package chapter6;

/**
 * 删除链表的倒数第N个节点
 *
 * @author youyu.song
 * @date 2020/9/4 20:48
 */
public class Leetcode19 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode dummyNode = new ListNode( -1);
        dummyNode.next = head;

        ListNode p = dummyNode;
        ListNode q = dummyNode;

        for (int i = 0; i <= n; i ++) {
            q = q.next;
        }

        while (q != null) {
            p = p.next;
            q = q.next;
        }

        p.next = p.next.next;

        return dummyNode.next;
    }

}
