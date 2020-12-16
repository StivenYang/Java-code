package top.hengshare.interview.algorithm.sort;

import java.util.Arrays;

public class Heap {

    private final static int[] arr = new int[]{1, 11, 11, 2, 12, 3, 4, 56, 33, 5, 6};
    private static int len = arr.length;

    public static int[] sort(int[] arr) {
        build(arr);
        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, 0, i);
            len--;
            heapify(arr, 0);
        }
        return arr;
    }

    public static void build(int[] arr) {
        int len = arr.length;
        for (int i = Math.floorDiv(len, 2); i >= 0; i--) {
            heapify(arr, i);
        }
    }

    public static void heapify(int[] arr, int midPoint) {
        int leftPoint = 2 * midPoint + 1;
        int rightPoint = 2 * midPoint + 2;
        int largestPoint = midPoint;
        if (leftPoint < len && arr[leftPoint] > arr[largestPoint]) {
            largestPoint = leftPoint;
        }
        if (rightPoint < len && arr[rightPoint] > arr[largestPoint]) {
            largestPoint = rightPoint;
        }
        if (largestPoint != midPoint) {
            swap(arr, midPoint, largestPoint);
            heapify(arr, largestPoint);
        }
    }

    public static void swap(int[] arr, int midPoint, int largestPoint) {
        int temp = arr[midPoint];
        arr[midPoint] = arr[largestPoint];
        arr[largestPoint] = temp;
    }

    public static void main(String[] args) {
        sort(arr);
        System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));
    }
}
