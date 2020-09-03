package chapter6;

/**
 * 反转链表
 *
 * @author youyu.song
 * @date 2020/9/3 22:40
 */
public class Leetcode206 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseList(ListNode head) {
        ListNode dummyNode = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = dummyNode;
            dummyNode = cur;
            cur = next;
        }

        return dummyNode;
    }

}
