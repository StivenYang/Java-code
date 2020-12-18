package top.hengshare.interview.algorithm.sort;

/**
 * 插入排序
 *
 * @author yangjiaheng
 * @date 2020/6/24 7:03 下午
 **/
public class Insertion {
    /**
     * 插入排序的原理：有两个下标，preIndex和curIndex,preIndex是已排序数组最大下标，curIndex是当前要插入的数的下标
     * 取这两个数，如果不满足条件交换，满足条件进行下一次循环
     *
     * @param arr 数组
     */
    public void sort(int[] arr) {
        int preIndex, current;
        for (int i = 1; i < arr.length; i++) {
            preIndex = i - 1;
            current = arr[i];
            while (preIndex >= 0 && arr[preIndex] < current) {
                arr[preIndex + 1] = arr[preIndex];
                preIndex--;
            }
            arr[preIndex + 1] = current;
        }
    }

}
