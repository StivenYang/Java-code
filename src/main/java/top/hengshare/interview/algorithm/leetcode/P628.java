package top.hengshare.interview.algorithm.leetcode;

import java.util.Arrays;

/**
 * P628 三个数的最大乘积
 *
 * @author v_yangjiaheng_dxm
 * @date 2020/10/14 10:20 上午
 **/
public class P628 {
    public static int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        return Math.max(nums[0] * nums[1] * nums[nums.length - 1],
                nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3]);
    }

    public static int maximumProduct1(int[] nums) {
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        for (int n : nums) {
            if (n <= min1) {
                min2 = min1;
                min1 = n;
            }
            if (n <= min2 && n > min1) {
                min2 = n;
            }
            if (n >= max1) {
                max3 = max2;
                max2 = max1;
                max1 = n;
            }
            if (n >= max2 && n < max1) {
                max3 = max2;
                max2 = n;
            }
            if (n >= max3 && n < max1 && n < max2) {
                max3 = n;
            }
        }
        return Math.max(min1 * min2 * max1, max1 * max2 * max3);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3};
        System.out.println(maximumProduct(arr));
        System.out.println(maximumProduct1(arr));
    }
}
