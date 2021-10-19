package top.hengshare.interview.algorithm.leetcode;

/**
 * P1275
 *
 * @author yjh
 * @since 2020/10/18
 */
public class Tictactoe {
	public static String tictactoe(int[][] moves) {
		String[][] arr = new String[3][3];
		for (int x = 0; x < moves.length; x++) {

		}
		boolean endFlag = false;
		for (String[] strings : arr) {
			for (int y = 0; y < strings.length; y++) {
				String flag = strings[y];
				if (flag == null) {
					endFlag = true;
					continue;
				}
				if ((flag.equals(strings[0]) && flag.equals(strings[1]) && flag.equals(strings[2])) || (
						flag.equals(arr[0][0]) && flag.equals(arr[1][1]) && flag.equals(arr[2][2])) || (
						flag.equals(arr[0][y]) && flag.equals(arr[1][y]) && flag.equals(arr[2][y]))) {
					if ("X".equals(flag)) {
						return "A";
					} else if ("O".equals(flag)) {
						return "B";
					}
				}
			}
		}
		if (endFlag) {
			return "Pending";
		} else {
			return "Draw";
		}
	}

	public static void main(String[] args) {
		int[][] moves = new int[][]{{0, 0}, {2, 0}, {1, 1}, {2, 1}, {2, 2}};
		System.out.println(tictactoe(moves));
	}
}
