package top.hengshare.interview.algorithm.leetcode;

import java.util.ArrayDeque;

/**
 * @author StevenYang
 * @description 获取滑动窗口每次滑动之后的最大值
 * @date 2020/7/19
 **/
public class MaxSlidingWindow {

    /**
     * 时间复杂度：O(nk)  空间复杂度：O(N-k+1)
     * @param nums
     * @param k
     * @return
     */
    public int[] maxWindow1(int[] nums, int k) {
        int n = nums.length;
        if (n * k == 0) {
            return new int[0];
        }

        int[] output = new int[n-k+1];
        //从第一个滑动窗口开始，一共有n-k+1个
        for (int i= 0; i<n-k+1; i++){
            int max = Integer.MIN_VALUE;
            //每个滑动窗口的索引是从i开始，i+k结束
            for (int j = i; j<i+k; j++){
                max= Math.max(max, nums[j]);
            }
            output[i] = max;
        }
        return output;
    }

    ArrayDeque<Integer> deq = new ArrayDeque<Integer>();
    int[] nums;

    public int[] maxWindow2(int[] nums, int k) {
        int n = nums.length;
        if (n * k == 0) {
            return new int[0];
        }
        if (k == 1) {
            return nums;
        }

        this.nums = nums;
        int max_idx = 0;
        //循环滑动窗口
        for (int i=0; i<k; i++){
            //清空队列，将当前元素放入队列，如果当前元素大于最大元素，那么保存最大值索引
            cleanDeque(i, k);
            deq.addLast(i);
            if (nums[i] > nums[max_idx]){
                max_idx = i;
            }
        }
        //初始化output，并将最大值放入output
        int[] output = new int[n-k+1];
        output[0] = nums[max_idx];

        //构建output
        for (int i=k; i<n; i++){
            cleanDeque(i, k);
            deq.addLast(i);
            output[i-k+1] = nums[deq.getFirst()];
        }
        return output;
    }

    public void cleanDeque(int i, int k){
        if (!deq.isEmpty() && deq.getFirst() == i - k) {
            deq.removeFirst();
        }
        while (!deq.isEmpty() && nums[i] > nums[deq.getLast()]){
            deq.removeLast();
        }
    }


}
