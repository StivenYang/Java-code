package top.hengshare.interview.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 四数之和
 *
 * @author StevenYang
 * @since 2020/7/21
 **/
public class FourSum {

	public List<List<Integer>> fourSum(int[] nums, int target) {
		ArrayList<List<Integer>> result = new ArrayList<>();
		if (nums == null || nums.length < 4) {
			return result;
		}
		Arrays.sort(nums);
		int len = nums.length;
		for (int k = 0; k < len - 3; k++) {
			if (k > 0 && nums[k] == nums[k - 1]) {
				continue;
			}

			int min1 = nums[k] + nums[k + 1] + nums[k + 2] + nums[k + 3];
			if (min1 > target) {
				break;
			}

			int max1 = nums[k] + nums[len - 1] + nums[len - 2] + nums[len - 3];
			if (max1 < target) {
				continue;
			}

			for (int i = k + 1; i < len - 2; i++) {
				if (i > k + 1 && nums[i] == nums[i - 1]) {
					continue;
				}

				int j = i + 1;
				int h = len - 1;

				int min = nums[k] + nums[i] + nums[j] + nums[j + 1];
				if (min > target) {
					continue;
				}

				while (j < h) {
					int curr = nums[k] + nums[i] + nums[j] + nums[h];
					if (curr == target) {
						result.add(Arrays.asList(nums[k], nums[i], nums[j], nums[h]));
						j++;
						while (j < h && nums[j] == nums[j - 1]) {
							j++;
						}

						h--;
						while (j < h && nums[h] == nums[h + 1]) {
							h--;
						}
					} else if (curr > target) {
						h--;
					} else {
						j++;
					}
				}
			}
		}
		return result;
	}
}
