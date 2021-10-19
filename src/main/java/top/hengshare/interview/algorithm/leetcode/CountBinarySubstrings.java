package top.hengshare.interview.algorithm.leetcode;

/**
 * P696 计数二进制子串
 *
 * @author v_yangjiaheng_dxm
 * @date 2020/10/14 8:59 下午
 **/
public class CountBinarySubstrings {
	public int countBinarySubstrings(String s) {
		String[] arr = s.split("");
		int len = arr.length;
		int count = 0;

		for (int i = 0; i < len - 1; i++) {
			String left = arr[i];
			String right = arr[i + 1];
			int leftIndex = i;
			int rightIndex = i + 1;

			if (!left.equals(right)) {
				while (leftIndex >= 0 && rightIndex <= len - 1) {
					if (arr[leftIndex].equals(left) && arr[rightIndex].equals(right)) {
						count++;
						leftIndex--;
						rightIndex++;
					} else
						break;
				}
			}
		}
		return count;
	}
}
