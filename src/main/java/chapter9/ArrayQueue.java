package chapter9;

/**
 * 数组实现的队列
 *
 * @author youyu.song
 * @date 2020/9/10 22:15
 */
public class ArrayQueue {

    private String[] arr;
    private int n;

    /** 队列中头元素和尾元素的下标 */
    private int head = 0;
    private int tail = 0;

    public ArrayQueue(int capacity) {
        arr = new String[capacity];
        n = capacity;
    }

    /**
     * 入队
     * @param item
     * @return
     */
    public boolean enqueue(String item) {
        if (tail ==  n) {
            return false;
        }
        arr[tail] = item;
        tail ++;

        return true;
    }

    /**
     * 出队
     * @return
     */
    public String dequeue() {
        // 此时队列为空
        if (head == tail) {
            return null;
        }
        String result = arr[head];
        head ++;

        return result;
    }

}
