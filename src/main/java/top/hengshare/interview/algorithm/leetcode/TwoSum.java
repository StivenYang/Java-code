package top.hengshare.interview.algorithm.leetcode;

import java.util.HashMap;

/**
 * 两数之和
 *
 * @author StevenYang
 * @date 2020/7/20
 **/
public class TwoSum {

    /**
     * 暴力法
     *
     * @param nums   数组
     * @param target 目的数
     * @return 满足数组
     */
    public int[] methodOne(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("没有满足条件的两个数");
    }

    /**
     * 两遍hash表
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] methodTwo(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int other = target - nums[i];
            if (map.containsKey(other) && map.get(other) != i) {
                return new int[]{i, map.get(other)};
            }
        }
        throw new IllegalArgumentException("没有满足条件的两个数");
    }

    /**
     * 一遍hash表
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] methodThree(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int other = target - nums[i];
            if (map.containsKey(other)) {
                return new int[]{map.get(other), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("没有满足条件的两个数");
    }
}
