package top.hengshare.interview.algorithm.sort;

import java.util.Arrays;

/**
 * Quick 快速排序
 *
 * @author yangjiaheng
 * @date 2020/7/10 1:52 下午
 **/
public class Quick {
    public static int[] arr = {1, 3, 5, 2, 11, 23, 34, 31, 12, 11};
    public static int count = 0;

    public static void sort(int[] arr, int l, int r) {
        if (l < r) {
            int i, j, x;
            i = l;
            j = r;
            x = arr[i];
            while (i < j) {
                while (i < j && arr[j] > x) {//右边向左找第一个小于x的元素
                    j--;
                }
                if (i < j) {//
                    arr[i++] = arr[j];
                }
                while (i < j && arr[i] < x) {
                    i++;
                }
                if (i < j) {
                    arr[j--] = arr[i];
                }
            }
            arr[i] = x;
            sort(arr, l, i - 1);
            sort(arr, i + 1, r);
        }
    }

    public static void main(String[] args) {
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
