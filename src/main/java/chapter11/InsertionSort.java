package chapter11;

import java.util.Arrays;

/**
 * @author youyu.song
 * @date 2020/11/3 17:21
 */
public class InsertionSort {

    /**
     * 插入排序
     * @param arr
     */
    public void insertionSort(int[] arr) {
        int n = arr.length;

        for (int i = 1; i < n; i ++) {
            int value = arr[i];
            int j;
            for (j = i - 1; j >= 0; j --) {
                if (arr[j] < value) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = value;
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 3, 1, 2};
        InsertionSort i = new InsertionSort();
        i.insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
