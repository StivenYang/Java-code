package top.hengshare.interview.algorithm.leetcode;

import java.util.Arrays;

/**
 * P832 翻转图像
 *
 * @author v_yangjiaheng_dxm
 * @date 2020/10/17 10:59 上午
 **/
public class P832 {
    public static int[][] flipAndInvertImage(int[][] A) {
        int row = A.length;
        int col = A[0].length;
        int[][] b = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                b[i][col - j - 1] = A[i][j] ^ 1;
            }
        }

        return b;
    }

    public static int[][] flipAndInvertImage1(int[][] A) {
        int C = A[0].length;
        for (int[] row : A)
            for (int i = 0; i < (C + 1) / 2; ++i) {
                int tmp = row[i] ^ 1;
                row[i] = row[C - 1 - i] ^ 1;
                row[C - 1 - i] = tmp;
            }

        return A;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1, 1, 0}, {1, 0, 1}, {0, 0, 0}};

        for (int[] ints : flipAndInvertImage(arr)) {
            System.out.println(Arrays.toString(ints));
        }
    }
}
