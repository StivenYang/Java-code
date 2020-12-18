package top.hengshare.interview.algorithm.sort;

/**
 * Shell排序
 *
 * @author yangjiaheng
 * @date 2020/6/27 11:39 上午
 **/
public class Shell {

    public void sort(int[] arr) {
        int gap = arr.length >> 1;
        while (gap > 0) {
            // 对每个子序列进行排序
            for (int i = 0; i < gap; i++) {
                // 插入排序的部分
                for (int j = i+gap; j < arr.length; j+=gap) {
                    int temp = j;
                    while (temp > i && arr[temp] < arr[temp-gap]) {
                        swap(arr, temp, temp-gap);
                        temp -= gap;
                    }
                }
            }
            gap >>= 1;
        }
    }

    public static void swap(int[] arr, int midPoint, int largestPoint) {
        int temp = arr[midPoint];
        arr[midPoint] = arr[largestPoint];
        arr[largestPoint] = temp;
    }
}
