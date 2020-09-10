package chapter9;

/**
 * 动态的数组队列, 不支持扩容
 *
 * @author youyu.song
 * @date 2020/9/10 22:26
 */
public class DynamicArrayQueue {

    private String[] arr;
    private int n;

    /**
     * 队列中头元素和尾元素的下标
     */
    private int head = 0;
    private int tail = 0;

    public DynamicArrayQueue(int capacity) {
        arr = new String[capacity];
        n = capacity;
    }

    public boolean enqueue(String item) {
        // 此时需要移动数据
        if (tail == n) {
            // 此时队列已满
            if (head == 0) {
                return false;
            }
            //int len = tail - head;
            //int i = 0;
            //for (; i < len; i++) {
            //    arr[i] = arr[head];
            //    head++;
            //}
            //head = 0;
            //tail = i++;

            for (int i = head; i < tail; i ++) {
                arr[i - head] = arr[i];
            }
            tail -= head;
            head = 0;
        }
        arr[tail] = item;
        tail++;

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
