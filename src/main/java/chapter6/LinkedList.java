package chapter6;

/**
 * 链表的简单实现
 *
 * @author youyu.song
 * @date 7/4/2020 10:17
 */
public class LinkedList<E> {

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

    private Node dummyHead;
    private int size;

    public LinkedList() {
        this.dummyHead = new Node();
        this.size = 0;
    }

    public int getSize() {
        return size;
    }

    /**
     * 在链表头部添加节点
     * @param e
     */
    public void addFirst(E e) {
        this.add(0, e);
    }

    /**
     * 在链表尾部添加节点
     * @param e
     */
    public void addLast(E e) {
        this.add(size, e);
    }

    /**
     * 在链表指定位置添加节点
     * @param index
     * @param e
     */
    public void add(int index, E e) {
        Node prev = dummyHead;
        for (int i = 0; i < index; i ++) {
            prev = prev.next;
        }

        Node node = new Node(e);
        node.next = prev.next;
        prev.next = node;

        size ++;
    }

    /**
     * 根据值在链表中查找节点
     * @param e
     * @return
     */
    public Node findByValue(E e) {
        while (dummyHead.next != null) {
            if (dummyHead.next.e != e) {
                dummyHead = dummyHead.next;
            } else {
                return dummyHead.next;
            }
        }

        return null;
    }

    /**
     * 根据索引查找链表中的节点
     * @param index
     * @return
     */
    public Node findByIndex(int index) {
        // index >= 0 && index < size
        Node head = dummyHead.next;
        while (head != null) {
            index --;
            head = head.next;
            if (index == 0) {
                break;
            }
        }

        return head;
    }

    /**
     * 根据索引移除节点
     * @param index
     * @return
     */
    public E remove(int index) {
        // index >= 0 && index < size
        Node head = dummyHead.next;
        for (int i = 0; i < index - 1; i ++) {
            head = head.next;
        }

        Node deleteNode = head.next;
        head.next = deleteNode.next;
        deleteNode.next = null;
        size --;

        return deleteNode.e;
    }

    /**
     * 根据给定的值移除节点
     * @param e
     */
    public void remove(E e) {
        Node prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.e.equals(e)) {
                break;
            }
            prev = prev.next;
        }

        if (prev.next != null) {
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            size --;
        }
    }

    /**
     * 移除首节点
     * @return
     */
    public E removeFirst() {
        return this.remove(0);
    }

    /**
     * 移除尾节点
     */
    public void removeLast() {
        this.remove(size - 1);
    }

}
