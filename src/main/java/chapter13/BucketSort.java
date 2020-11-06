package chapter13;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;

/**
 * 桶排序
 *
 * @author youyu.song
 * @date 2020/11/6 15:22
 */
public class BucketSort {

    /**
     * @param arr 要排序的数组
     * @param bucketSize 每个桶的容量
     */
    public void bucketSort(int[] arr, int bucketSize) {
        // 1.找到桶中所有元素的最大值和最小值
        int len = arr.length;
        int minValue = arr[0];
        int maxValue = arr[1];
        for (int i = 0; i < len; i ++) {
            if (arr[i] < minValue) {
                minValue = arr[i];
            } else if (arr[i] > maxValue) {
                maxValue = arr[i];
            }
        }

        // 2.确定桶的数量，将数组中的值放入到桶中
        // 桶数量
        int bucketCount = (maxValue - minValue) / bucketSize + 1;
        // 桶个数以及每个桶的容量
        int[][] buckets = new int[bucketCount][bucketSize];
        // 下标为几号桶，值为桶中已存放的数据个数，也可以记录下一次数据放入时的索引位置
        int[] bucketArr = new int[bucketCount];

        for (int i = 0; i < len; i ++) {
            // 确定要放入几号桶
            int bucketIndex = (arr[i] - minValue) / bucketSize;
            if (bucketArr[bucketIndex] == buckets[bucketIndex].length) {
                // 该桶中数据已放满，需要扩容
                this.expandCapacity(buckets, bucketIndex);
            }
            buckets[bucketIndex][bucketArr[bucketIndex]] = arr[i];
            bucketArr[bucketIndex] ++;
        }

        // 3.对每个桶中的数据进行排序，使用 chapter12 中的快速排序
        int k = 0;
        for (int i = 0; i < bucketArr.length; i ++) {
            // 该桶中没有放入数据，则不需要排序
            if (bucketArr[i] == 0) {
                continue;
            }
            // r 参数：对桶中实际存放的元素进行排序
            this.sort(buckets[i], 0, bucketArr[i] - 1);
            for (int j = 0; j < bucketArr[i]; j ++) {
                arr[k] = buckets[i][j];
                k ++;
            }
        }

    }

    /**
     * 快速排序
     * @param arr
     * @param l
     * @param r
     */
    private void sort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }

        int p = partition(arr, l, r);
        sort(arr, l, p - 1);
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

    /**
     * 对桶的容量进行扩容
     * @param buckets
     * @param bucketIndex
     */
    private void expandCapacity(int[][] buckets, int bucketIndex) {
        int[] tempArr = buckets[bucketIndex];
        int[] newArr = new int[tempArr.length * 2];
        for (int j = 0; j < tempArr.length; j++) {
            newArr[j] = tempArr[j];
        }
        buckets[bucketIndex] = newArr;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 4, 6, 7, 5, 9, 3, 8, 11, 10};
        new BucketSort().bucketSort(arr, 2);
        System.out.println(Arrays.toString(arr));
    }


}
