package top.hengshare.interview.algorithm.sort;

/**
 * 选择排序
 *
 * @author yangjiaheng
 * @date 2020/6/23 6:01 下午
 **/
public class Selection {

    /**
     * 选择排序的原理是：拿开头的数，然后依次让这个数和其他的数进行比较，如果是从大到小排序，那就取最大值，否则取最小值
     *
     * @param arr 数组
     */
    public void sort(int[] arr) {
        for(int i = 0; i<arr.length; i++){
            int maxIndex = i;
            for (int j = i; j<arr.length; j++){
                if(arr[j] > arr[maxIndex]){
                    maxIndex = j;
                }
            }
            int temp = arr[maxIndex];
            arr[maxIndex] = arr[i];
            arr[i] = temp;
        }
    }
}
