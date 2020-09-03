package chapter6;

/**
 * 检测链表中是否有环
 *
 * @author youyu.song
 * @date 2020/9/3 22:59
 */
public class Leetcode141 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next.next;

        while (fast != null) {
            if (slow == fast) {
                return true;
            }
            slow = slow.next;
            if (fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
            } else {
                fast = fast.next;
            }
        }

        return false;
    }


}
