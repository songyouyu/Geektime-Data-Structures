package chapter13;

import java.util.Arrays;

/**
 * 计数排序:只能用在数据范围不大的场景中.
 *
 * @author youyu.song
 * @date 2020/11/9 16:50
 */
public class CountingSort {

    public void countingSort(int[] arr) {
        int len = arr.length;

        // 找出数组中的最大值
        int max = arr[0];
        for (int i = 1; i < len; i ++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        // 建立一个数组，数组索引范围[0...max]
        // c 中的下标为 arr 中的值，值为 arr 中值相等的个数
        int[] c = new int[max + 1];
        for (int i = 0; i < len; i ++) {
            c[arr[i]] ++;
        }

        // 对 c 中的数据进行累加
        for (int i = 1; i < c.length; i ++) {
            // c[i] 为小于等于 i 值的总个数.
            c[i] += c[i - 1];
        }

        int[] r = new int[len];
        for (int i = len - 1; i >= 0; i --) {
            // c[arr[i]] 说明该值在 r 中的位置. 具体下标需要 -1.
            int index = c[arr[i]] - 1;
            r[index] = arr[i];
            // 此时该位置上的一个值已经放入 r 中，总个数需要 -1.
            c[arr[i]] --;
        }

        for (int i = 0; i < len; i ++) {
            arr[i] = r[i];
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 4, 6, 7, 5, 9, 3, 8, 11, 10};
        new CountingSort().countingSort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
