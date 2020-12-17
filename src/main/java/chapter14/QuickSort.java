package chapter14;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;

/**
 * 随机化双路快排、三路快排
 *
 * @author youyu.song
 * @date 2020/11/26 22:13
 */
public class QuickSort {

    public void sort2Ways(int[] arr) {
        int n = arr.length;
        sort2Ways(arr, 0, n - 1);
    }

    private void sort2Ways(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int p = partition(arr, l, r);
        sort2Ways(arr, l, p - 1);
        sort2Ways(arr, p + 1, r);
    }

    private int partition(int[] arr, int l, int r) {
        // 随机在数组中取一个值与数组中最左边的值交换
        ArrayUtils.swap(arr, l, (int) (Math.random()*(r - l + 1) + l));
        int tmp = arr[l];

        int i = l + 1;
        int j = r;
        while (true) {
            while (i <= r && arr[i] < tmp) {
                i ++;
            }
            while (j >= l + 1 && arr[j] > tmp) {
                j --;
            }
            if (i > j) {
                break;
            }
            ArrayUtils.swap(arr, i, j);
            i ++;
            j --;
        }

        ArrayUtils.swap(arr, l, j);
        return j;
    }


    public void sort3Ways(int[] arr) {
        int n = arr.length;
        sort3Ways(arr, 0, n - 1);
    }

    private void sort3Ways(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }

        ArrayUtils.swap(arr, l, (int) (Math.random()*(r - l + 1) + l));
        int tmp = arr[l];

        int lt = l;
        int gt = r + 1;
        int i = l + 1;
        while (i < gt) {
            if (arr[i] < tmp) {
                ArrayUtils.swap(arr, i, lt + 1);
                i ++;
                lt ++;
            } else if (arr[i] == tmp) {
                i ++;
            } else {
                ArrayUtils.swap(arr, i, gt - 1);
                gt --;
            }
        }

        ArrayUtils.swap(arr, l, lt);
        sort3Ways(arr, l, lt - 1);
        sort3Ways(arr, gt, r);
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 4, 6, 7, 5, 9, 3, 8, 11, 10};
        new chapter14.QuickSort().sort2Ways(arr);
        System.out.println(Arrays.toString(arr));
    }

}
