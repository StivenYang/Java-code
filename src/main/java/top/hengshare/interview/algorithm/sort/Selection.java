package top.hengshare.interview.algorithm.sort;

/**
 * 选择排序
 *
 * @author yangjiaheng
 * @date 2020/6/23 6:01 下午
 **/
public class Selection {

    public static int[] arr = {1, 3, 5, 2, 11, 23, 34, 31, 12, 11};
    public static int count = 0;

    private static void sort(int[] arr){
        int minIndex, temp;
        for (int i = 0; i<arr.length; i++){
            minIndex = i;
            for (int j= i+1; j<arr.length; j++){
                if (arr[j] < arr[minIndex]){
                    minIndex = j;
                }
                count++;
            }
            temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex]= temp;
        }
    }

    public static void main(String[] args) {
        sort(arr);
        for (int i : arr) {
            System.out.print(i + "\t");
        }
        System.out.println(count);
    }
}
