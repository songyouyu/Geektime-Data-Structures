package chapter13;

import java.util.Arrays;

/**
 * 基数排序:对于需要排序的数据有一定的要求。
 *
 * @author youyu.song
 * @date 2020/11/16 下午5:23
 */
public class RadixSort {

    public void radixSort(int[] arr) {
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        // 从个位开始排序
        for (int exp = 1; max / exp > 0; exp *= 10) {
            sort(arr, exp);
        }
    }

    private void sort(int[] arr, int exp) {
        if (arr.length <= 1) {
            return;
        }

        // 使用计数排序. 0-9 一共10个数.
        int[] c = new int[10];
        for (int i = 0; i < arr.length; i ++) {
            c[(arr[i] / exp) % 10] ++;
        }

        for (int i = 1; i < c.length; i ++) {
            c[i] += c[i - 1];
        }

        int[] r = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i --) {
            int index = c[(arr[i] / exp) % 10] - 1;
            r[index] = arr[i];
            c[(arr[i] / exp) % 10] --;
        }

        for (int i = 0; i < arr.length; i ++) {
            arr[i] = r[i];
        }
    }

    public static void main(String[] args) {
        int[] arr = {73, 22, 93, 43, 5};
        new RadixSort().radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
