package top.hengshare.interview.algorithm.sort;

import java.util.Arrays;

/**
 * 归并排序
 * <p>
 * 归并排序是建立在归并操作上的一种有效的排序算法，采用分治法的一个典型应用。
 * 思想是：将有序的子序列进行合并，可以得到一个完全有序的序列。
 * 将两个有序表合并成一个有序表，为2-路归并
 *
 * @author yangjiaheng
 * @date 2020/6/30 10:00 上午
 **/
public class Merge {
    public static int[] arr = {1, 3, 5, 2, 11, 23, 34, 31, 12, 11};
    public static int count = 0;

    public static void sort(int[] arr) {
        int[] temp = new int[arr.length];
        //在排序之前，先创建好一个长度等于原数组长度的临时数组
        //避免递归中频繁开辟空间
        sort(arr, 0, arr.length - 1, temp);
    }

    public static void sort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            sort(arr, left, mid, temp);
            //左边数组拆分，使得左子序列有序
            sort(arr, mid + 1, right, temp);
            //右边数组拆分，使得右子序列有序
            merge(arr, left, mid, right, temp);
            //合并子序列
        }
    }

    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;//左序列指针
        int j = mid + 1;//右序列指针
        int t = 0;//临时数组指针
        while (i <= mid && j <= right) {
            if (arr[i] < arr[j]) {
                temp[t++] = arr[i++];
            } else {
                temp[t++] = arr[j++];
            }
        }
        while (i <= mid) {//将左边剩余元素填充进temp中
            temp[t++] = arr[i++];
        }
        while (j <= right) {//将右边剩余元素填充进temp中
            temp[t++] = arr[j++];
        }
        t = 0;
        //将temp中的元素全部拷贝到原数组中
        while (left <= right) {
            arr[left++] = temp[t++];
        }
    }

    public static void main(String[] args) {
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
