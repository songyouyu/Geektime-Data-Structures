package chapter11;

import java.util.Arrays;

/**
 * @author youyu.song
 * @date 2020/11/3 17:43
 */
public class SelectionSort {

    /**
     * 选择排序
     * @param arr
     */
    public void selectionSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n; i ++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j ++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            this.swap(arr, i, minIndex);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[j];
        arr[j] = arr[i];
        arr[i] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 3, 2, 1};
        new SelectionSort().selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
