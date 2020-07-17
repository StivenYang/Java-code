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

    public static void sort(int[] arr, int left, int right) {
        if (left < right) {
            int i, j, x;
            i = left;
            j = right;
            x = arr[i];
            while (i < j) {
                //有一个左值针和右指针，如果左值针和右指针没有重合
                while (i < j && arr[j] > x) {
                    //如果左值针和右指针没有重合，且右指针指向的元素大于左指针指向的元素，
                    // 让右指针往左移，直到碰见右指针指向的元素小于或者等于左值针的元素
                    j--;
                }
                if (i < j) {
                    //如果左值针和右指针没有重合，就让右指针指向的元素的值赋给左指针指向的元素，并将左值针向右移动一位
                    arr[i++] = arr[j];
                }
                while (i < j && arr[i] < x) {
                    //如果左值针和右指针没有重合，且左值针指向的元素小于左值针指向的元素，将左值针右移一位
                    i++;
                }
                if (i < j) {
                    //如果本轮还没完，就将右指针左移一位，并交换左右指针指向的值
                    arr[j--] = arr[i];
                }
            }
            arr[i] = x;
            sort(arr, left, i - 1);
            sort(arr, i + 1, right);
        }
    }

    public static void main(String[] args) {
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
