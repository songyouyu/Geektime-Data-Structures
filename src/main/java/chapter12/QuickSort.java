package chapter12;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;

/**
 * @author youyu.song
 * @date 2020/11/4 16:21
 */
public class QuickSort {

    /**
     * 快速排序
     * @param arr
     */
    public void quickSort(int[] arr) {
        int n = arr.length;
        sort(arr, 0, n - 1);
    }

    private void sort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }

        int p = partition(arr, l, r);
        sort(arr, l, p);
        sort(arr, p + 1, r);
    }

    private int partition(int[] arr, int l, int r) {
        int tmp = arr[l];
        int i = l;
        for (int j = l + 1; j <= r; j ++) {
            if (arr[j] < tmp) {
                i ++;
                if (i != j) {
                    ArrayUtils.swap(arr, i , j);
                }
            }
        }
        ArrayUtils.swap(arr, l, i);

        return i;
    }

    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 1, 7, 5, 6, 9, 8};
        new QuickSort().quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
