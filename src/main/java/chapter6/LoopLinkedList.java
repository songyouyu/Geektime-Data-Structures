package chapter6;

/**
 * 简单循环链表的实现
 *
 * @author youyu.song
 * @date 2020/8/27 11:19
 */
public class LoopLinkedList<E> {

    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }
    }

    public LoopLinkedList() {

    }

    private Node headNode = new Node();
    private Node lastNode = headNode;

    /**
     * 添加头节点
     * @param e
     */
    public void addFirst(E e) {
        Node newHead = new Node(e);
        newHead.next = headNode.next;
        headNode.next = newHead;
    }

    /**
     * 在链表的尾部添加节点
     * @param e
     */
    public void addLast(E e) {
        Node node = new Node(e);
        lastNode.next = node;
        node.next = headNode;
        lastNode = node;
    }

    /**
     * 在指定节点前添加节点
     * @param node
     * @param e
     */
    public void addBeforeNode(Node node, E e) {
        if (node == headNode) {
            this.addFirst(e);
            return;
        }
        Node newNode = new Node(e);
        Node tempNode = headNode;
        // 找到指定节点的前一个节点
        while (tempNode.next != node) {
            tempNode = tempNode.next;
        }
        newNode.next = tempNode.next;
        tempNode.next = newNode;
    }

    /**
     * 移除链表头部的节点
     */
    public void removeFirst() {
        Node tempNode = headNode;
        while (tempNode.next != headNode) {
            tempNode = tempNode.next;
        }
        tempNode.next = headNode.next;
        headNode.next = null;
        headNode = tempNode.next;
    }

    /**
     * 移除链表尾部的节点
     */
    public void removeLast() {
        Node curNode = headNode;
        while (curNode.next != lastNode) {
            curNode = curNode.next;
        }
        curNode.next = headNode;
        lastNode.next = null;
        lastNode = curNode;
    }

    /**
     * 移除指定的节点
     * @param node
     */
    public void removeByNode(Node node) {
        if (node == headNode) {
            this.removeFirst();
            return;
        }

        Node tempNode = headNode;
        while (tempNode.next != node) {
            tempNode = tempNode.next;
        }
        tempNode.next = node.next;
        node.next = null;
        if (node == lastNode) {
            lastNode = tempNode;
        }
    }

}
