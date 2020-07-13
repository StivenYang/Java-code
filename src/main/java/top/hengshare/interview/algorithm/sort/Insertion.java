package top.hengshare.interview.algorithm.sort;

/**
 * 插入排序
 *
 * @author yangjiaheng
 * @date 2020/6/24 7:03 下午
 **/
public class Insertion {

    public static int[] arr = {1, 3, 5, 2, 11, 23, 34, 31, 12, 11};
    public static int count = 0;

    private static void sort(int[] arr) {
        int preIndex, current;
        for (int i=1; i<arr.length; i++){
            preIndex = i-1;
            current = arr[i];
            while (preIndex >= 0 && current<arr[preIndex]){
                arr[preIndex+1]=arr[preIndex];
                preIndex--;
            }
            arr[preIndex+1] = current;
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
