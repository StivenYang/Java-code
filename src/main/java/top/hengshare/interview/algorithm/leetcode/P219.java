package top.hengshare.interview.algorithm.leetcode;

import java.security.Key;

/**
 * P219 存在重复元素 II
 *
 * @author v_yangjiaheng_dxm
 * @date 2020/10/16 4:50 下午
 **/
public class P219 {
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        int len = nums.length;

        if (k == 0 ||  len == 0) {
            return false;
        }

        if (len == 1) {
            return false;
        }

        if (len == 2 && nums[0] == nums[1]) {
            return true;
        }

        for (int i = 0; i < len-1; i++) {
            int temp = 1;
            while (temp <= k) {
                if (i + temp < len && nums[i] == nums[i + temp]) {
                    return true;
                }

                temp++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 1, 2, 3};
        System.out.println(containsNearbyDuplicate(arr, 2));
    }
}
