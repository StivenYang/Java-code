package top.hengshare.interview.algorithm.sort;

/**
 * Shell排序
 *
 * @author yangjiaheng
 * @date 2020/6/27 11:39 上午
 **/
public class Shell {
    public static int[] arr = {1, 3, 5, 2, 11, 23, 34, 31, 12, 11};
    public static int count = 0;

    private static void sort(int[] arr) {
        int len = arr.length;
        for (int gap = Math.floorDiv(len, 2); gap > 0; gap = Math.floorDiv(gap, 2)) {
            for (int i = gap; i < len; i++) {
                int j = i;
                int current = arr[i];
                while (j - gap >= 0 && current < arr[j - gap]) {
                    arr[j] = arr[j - gap];
                    j = j - gap;
                }
                arr[j] = current;
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
