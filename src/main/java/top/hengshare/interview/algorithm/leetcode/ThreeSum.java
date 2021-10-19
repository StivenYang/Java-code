package top.hengshare.interview.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author StevenYang
 * @description 三数之和
 * @date 2020/7/20
 **/
public class ThreeSum {

	/**
	 * 大小指针法
	 *
	 * @param nums
	 * @return
	 */
	public List<List<Integer>> threeSum(int[] nums) {
		int len = nums.length;
		Arrays.sort(nums);
		ArrayList<List<Integer>> lists = new ArrayList<>();
		//枚举a
		for (int first = 0; first < len; first++) {
			if (first > 0 && nums[first] == nums[first - 1]) {
				continue;
			}
			int third = len - 1;
			int target = -nums[first];
			for (int second = first + 1; second < len; ++second) {
				//枚举b，b和a不相同，且b>a
				if (second > first + 1 && nums[second] == nums[second - 1]) {
					continue;
				}
				//枚举c，c和a b不相同，且c>b
				while (second < third && nums[second] + nums[third] > target) {
					--third;
				}
				if (second == third) {
					break;
				}
				if (nums[second] + nums[third] == target) {
					ArrayList<Integer> list = new ArrayList<>();
					list.add(nums[first]);
					list.add(nums[second]);
					list.add(nums[third]);
					lists.add(list);
				}
			}
		}
		return lists;
	}
}
