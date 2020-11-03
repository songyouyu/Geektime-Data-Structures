package chapter10;

import java.util.Arrays;

/**
 * @author youyu.song
 * @date 2020/11/3 16:36
 */
public class BubbleSort {

    /**
     * 冒泡排序
     * @param arr
     */
    public void bubbleSort(int[] arr) {
        int n = arr.length;

        //for (int i = 0; i < n - 1; i ++) {
        //    for (int j = 0; j < n - 1 - i; j ++) {
        //        if (arr[j] > arr[j + 1]) {
        //            this.swap(arr, j, j + 1);
        //        }
        //    }
        //}


        for (int i = 0; i < n - 1; i ++) {
            boolean flag = false;
            for (int j = 0; j < n - 1 - i; j ++) {
                if (arr[j] > arr[j + 1]) {
                    this.swap(arr, j, j + 1);
                    flag = true;
                }
            }
            // 没有数据交换，说明数组已经有序
            if (!flag) {
                break;
            }
        }

    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[j];
        arr[j] = arr[i];
        arr[i] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 3, 2, 1};
        BubbleSort b = new BubbleSort();
        b.bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
