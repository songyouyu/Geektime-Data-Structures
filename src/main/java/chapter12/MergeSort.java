package chapter12;

import java.util.Arrays;

/**
 * @author youyu.song
 * @date 2020/11/4 15:39
 */
public class MergeSort {

    /**
     * 归并排序
     * @param arr
     */
    public void mergeSort(int[] arr) {
        int n = arr.length;
        sort(arr, 0, n - 1);
    }

    private void sort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = l + (r - l) / 2;
        sort(arr, l, mid);
        sort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    private void merge(int[] arr, int l, int mid, int r) {
        int[] tmp = Arrays.copyOfRange(arr, l, r + 1);

        // ij 分别为左右起始索引
        int i = l;
        int j = mid + 1;
        for (int k = l; k <= r; k ++) {
            if (i > mid) {
                arr[k] = tmp[j - l];
                j ++;
            } else if (j > r) {
                arr[k] = tmp[i - l];
                i ++;
            } else if (tmp[i - l] < tmp[j - l]) {
                arr[k] = tmp[i - l];
                i ++;
            } else {
                arr[k] = tmp[j - l];
                j ++;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 4, 7, 5, 6, 9, 8};
        new MergeSort().mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
