package top.hengshare.interview.algorithm.sort;

/**
 * 冒泡排序
 *
 * @author yangjiaheng
 * @date 2020/6/23 5:49 下午
 **/
public class Bubble {

    public static int[] arr = {1, 3, 5, 2, 11, 23, 34, 31, 12, 11};
    public static int count = 0;

    private static void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] < arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    count++;
                }
            }
        }
    }

    public static void main(String[] args) {
        sort(arr);
        for (int i : arr) {
            System.out.print(i + ", ");
        }
        System.out.println();
        System.out.println(count);
    }
}
