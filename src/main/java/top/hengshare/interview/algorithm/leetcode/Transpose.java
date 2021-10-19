package top.hengshare.interview.algorithm.leetcode;

import java.util.Arrays;

/**
 * P867 转置矩阵
 *
 * @author yangjiaheng
 * @date 2020/10/13 7:01 下午
 **/
public class Transpose {

	public static int[][] transpose(int[][] A) {
		int col = A[0].length;
		int row = A.length;
		int[][] temp = new int[col][row];

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				temp[j][i] = A[i][j];
			}
		}

		return temp;
	}

	public static void main(String[] args) {
		int[][] arr = new int[][]{{1, 2, 3}, {1, 2, 3}};
		int[][] transpose = transpose(arr);
		System.out.println(Arrays.toString(transpose));
	}
}
