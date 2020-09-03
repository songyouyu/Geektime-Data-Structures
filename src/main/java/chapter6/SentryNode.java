package chapter6;

/**
 * 使用哨兵机制
 *
 * @author youyu.song
 * @date 2020/9/3 22:12
 */
public class SentryNode {

    /**
     * 在数组 a 中，查找 key，返回 key 所在的位置
     * @param arr
     * @param n
     * @param key
     * @return
     */
    public int find(int[] arr, int n, int key) {
        if (arr == null || n < 0) {
            return -1;
        }

        // 需要把 n-1 的值替换成 key, 所以特殊处理
        if (arr[n - 1] == key) {
            return n - 1;
        }

        // 把 arr[n-1] 的值临时保存在变量 tmp 中，以便之后恢复
        // 不希望改变原数组中的值
        int tmp = arr[n - 1];
        arr[n - 1] = key;

        int i = 0;
        while (arr[i] != key) {
            i ++;
        }

        // 恢复原数组中的值
        arr[n - 1] = tmp;
        if (i == n - 1) {
            // 此时说明 arr 中没有 key, 所以返回 -1
            return -1;
        } else {
            return i;
        }
    }

}
