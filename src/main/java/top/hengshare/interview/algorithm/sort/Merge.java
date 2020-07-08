//package top.hengshare.interview.algorithm.sort;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
///**
// * 归并排序
// *
// * 归并排序是建立在归并操作上的一种有效的排序算法，采用分治法的一个典型应用。
// * 思想是：将有序的子序列进行合并，可以得到一个完全有序的序列。
// * 将两个有序表合并成一个有序表，为2-路归并
// *
// * @author yangjiaheng
// * @date 2020/6/30 10:00 上午
// **/
//public class Merge {
//    public static int[] arr = {1, 3, 5, 2, 11, 23, 34, 31, 12, 11};
//    public static int count = 0;
//
//    private static int[] sort(int[] arr) {
//        int len = arr.length;
//        if (len<2){
//            return arr;
//        }
//        int middle = Math.floorDiv(len, 2);
//        int[] left = Arrays.copyOfRange(arr, 0, middle);
//        int[] right = Arrays.copyOfRange(arr, middle, len);
//        return merge(sort(left), sort(right));
//    }
//
//    public static int[] merge(int[] left, int[] right){
//        List<Integer> result = new ArrayList<>();
//        while (left.length>0 && right.length>0){
//            if (left[0]<=right[0]){
//                result.add(left);
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//        sort(arr);
//        for (int i : arr) {
//            System.out.print(i + ", ");
//        }
//        System.out.println();
//        System.out.println(count);
//    }
//}
