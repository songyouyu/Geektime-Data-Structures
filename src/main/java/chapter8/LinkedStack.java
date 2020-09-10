package chapter8;

/**
 * @author youyu.song
 * @date 2020/9/5 12:23
 */
public class LinkedStack<E> {

    private LinkedList<E> linkedList;

    private LinkedStack() {
        linkedList = new LinkedList<>();
    }

    public void push(E e) {
        linkedList.addLast(e);
    }

    public E pop() {
        return linkedList.removeLast();
    }

}
