package top.hengshare.interview.algorithm.leetcode;

import java.util.Arrays;

/**
 * P977
 *
 * @author v_yangjiaheng_dxm
 * @date 2020/10/13 8:40 下午
 **/
public class P977 {
    public static int[] sortedSquares(int[] A) {
        int len = A.length;
        int[] rtn = new int[len];
        int right = len-1;
        int left = 0;
        int fillPoint = len-1;
        while (right+1 != left) {
            if (A[left] < 0) {
                if (A[right] > 0) {
                    if (Math.abs(A[left]) > Math.abs(A[right])) {
                        rtn[fillPoint--] = A[left] * A[left];
                        left++;
                    }else {
                        rtn[fillPoint--] = A[right] * A[right];
                        right--;
                    }
                }else {
                    rtn[fillPoint--] = A[left] * A[left];
                    left++;
                }
            }else {
                rtn[fillPoint--] = A[right] * A[right];
                right--;
            }
        }
        return rtn;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-7,-3,2,3,11};
        System.out.println(Arrays.toString(sortedSquares(arr)));
    }
}
