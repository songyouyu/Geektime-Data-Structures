package chapter15;

/**
 * 二分查找法
 *
 * @author songyouyu
 * @date 2021/4/23 23:21
 */
public class BinarySearch {

    /**
     * 非递归
     * @param arr
     * @param target
     * @return
     */
    public int bsearch1(int[] arr, int target) {
        int len = arr.length;
        int l = 0, r = len - 1;

        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (target == arr[mid]) {
                return mid;
            } else if (target < arr[mid]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return -1;
    }

    /**
     * 递归
     * @param arr
     * @param target
     * @return
     */
    public int bsearch2(int[] arr, int target) {
        int len = arr.length;
        int l = 0, r = len - 1;

        return bsearchInternally(arr, l, r, target);
    }

    private int bsearchInternally(int[] arr, int l, int r, int target) {
        if (l > r) {
            return -1;
        }

        int mid = l + ((r - l) >> 1);
        if (target == arr[mid]) {
            return mid;
        } else if (target < arr[mid]) {
            return bsearchInternally(arr, l, mid - 1, target);
        } else {
            return bsearchInternally(arr, mid + 1, r, target);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 12, 34, 45, 567, 897};
        System.out.println(new BinarySearch().bsearch1(arr, 897));
        System.out.println(new BinarySearch().bsearch2(arr, 1));
    }

}
