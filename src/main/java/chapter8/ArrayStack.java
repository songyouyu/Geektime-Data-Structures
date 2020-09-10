package chapter8;

/**
 * 使用数组实现栈
 *
 * @author youyu.song
 * @date 2020/9/5 12:21
 */
public class ArrayStack<E> {

    private Array<E> array;

    private ArrayStack() {
        array = new Array<>();
    }

    private ArrayStack(int capacity) {
        array = new Array<>(capacity);
    }

    public void push(E e) {
        array.addLast(e);
    }

    public E pop() {
        return array.removeLast();
    }

    public E peek() {
        return array.getLast();
    }

}
