package chapter9;

/**
 * 基于数组的循环队列
 *
 * @author youyu.song
 * @date 2020/10/26 21:23
 */
public class CircularQueue {

    private String[] items;
    private int n = 0;

    private int head = 0;
    private int tail = 0;

    public CircularQueue(int capacity) {
        items = new String[capacity];
        n = capacity;
    }

    public boolean enqueue(String item) {
        // 队列已满
        if ((tail + 1) % n == head) {
            return false;
        }
        items[tail] = item;
        tail = (tail + 1) % n;

        return true;
    }

    public String dequeue() {
        // 此时队列为空
        if (head == tail) {
            return null;
        }
        String s = items[head];
        head = (head + 1) % n;

        return s;
    }

}
