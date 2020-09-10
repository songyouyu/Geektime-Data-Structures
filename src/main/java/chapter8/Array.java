package chapter8;

/**
 * 数组的简单实现
 *
 * @author youyu.song
 * @date 2020/8/23 16:33
 */
public class Array<E> {

    private E[] data;
    private int size;

    public Array(int capacity) {
        data = (E[])new Object[capacity];
        size = 0;
    }

    /**
     * 默认初始化容量为 10.
     */
    public Array() {
        this(10);
    }

    /**
     * 获取数组的容量
     * @return
     */
    public int getCapacity(){
        return data.length;
    }

    /**
     * 获取数组中的元素个数
     * @return
     */
    public int getSize(){
        return size;
    }

    /**
     * 返回数组是否为空
     * @return
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 在数组尾部添加元素
     * @param e
     */
    public void addLast(E e) {
        this.add(size, e);
    }

    /**
     * 移除数组尾部元素
     * @return
     */
    public E removeLast() {
        return this.remove(size - 1);
    }

    /**
     * 获得数组尾部元素, 但不删除
     * @return
     */
    public E getLast() {
        return data[size - 1];
    }

    /**
     * 在索引 index 的位置添加元素 e.
     * @param index
     * @param e
     */
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index >= 0 || index <= size");
        }

        // 数组中实际存储的数据长度和数组长度相等时, 需要扩容
        if (size == data.length) {
            this.resize(data.length * 2);
        }
        for (int i = size - 1; i >= index; i --) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size ++;
    }

    /**
     * 从数组中删除 index 位置的元素, 返回删除的元素
     * @param index
     * @return
     */
    public E remove(int index){
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("index is illegal");
        }
        E e = data[index];
        for (int i = index + 1; i < size; i ++) {
            data[i - 1] = data[i];
        }

        size --;
        data[size] = null;
        // 防止增加和删除元素时, 导致数组频繁的 resize 操作
        if (size == data.length / 4 && data.length / 2 != 0) {
            this.resize(data.length / 2);
        }

        return e;
    }

    /**
     * 将数组的空间扩容至 newCapacity 大小.
     * @param newCapacity
     */
    private void resize(int newCapacity) {
        E[] e = (E[])new Object[newCapacity];
        for (int i = 0; i < size; i ++) {
            e[i] = data[i];
        }

        data = e;
    }

}
