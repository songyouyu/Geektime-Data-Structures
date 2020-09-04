package chapter6;

/**
 * 链表的中间节点
 *
 * @author youyu.song
 * @date 2020/9/4 20:50
 */
public class Leetcode876 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode middleNode(ListNode head) {
        if (head.next == null) {
            return head;
        }
        if (head.next.next == null) {
            return head.next;
        }

        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode slow = dummyNode;
        ListNode fast = dummyNode;

        while (fast != null) {
            if ((fast.next == null) || (fast.next != null && fast.next.next == null)) {
                slow = slow.next;
                break;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        System.out.println(new Leetcode876().middleNode(node).val);
    }

}
