package chapter9;

/**
 * 基于链表的队列
 *
 * @author youyu.song
 * @date 2020/10/26 21:12
 */
public class QueueBasedOnLinkedList {

    private static class Node {
        private String data;
        private Node next;

        public Node(String data, Node next) {
            this.data = data;
            this.next = next;
        }

        public String getData() {
            return data;
        }
    }

    private Node head = null;
    private Node tail = null;

    public boolean enqueue(String item) {
        if (tail == null) {
            Node node = new Node(item, null);
            head = node;
            tail = node;
        } else {
            tail.next = new Node(item, null);
            tail = tail.next;
        }

        return true;
    }

    public String dequeue() {
        Node node = head;
        head = head.next;
        if (head == null) {
            tail = null;
        }

        return node.getData();
    }

}
