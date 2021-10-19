package top.hengshare.interview.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * P514
 *
 * @author yjh
 * @since 2020/11/11
 */
public class FindRotateSteps {

	public int findRotateSteps(String ring, String key) {
		int n = ring.length();
		int m = key.length();
		List<Integer>[] pos = new List[26];
		for (int i = 0; i < 26; i++) {
			pos[i] = new ArrayList<>();
		}
		for (int i = 0; i < n; i++) {
			pos[ring.charAt(i) - 'a'].add(i);
		}
		int[][] dp = new int[m][n];
		for (int i = 0; i < m; i++) {
			Arrays.fill(dp[i], 0x3f3f3f);
		}
		for (int i : pos[key.charAt(0) - 'a']) {
			dp[0][i] = Math.min(i, n - i) + 1;
		}
		for (int i = 1; i < m; ++i) {
			for (int j : pos[key.charAt(i) - 'a']) {
				for (int k : pos[key.charAt(i - 1) - 'a']) {

				}
			}
		}
		return 0;
	}

}
