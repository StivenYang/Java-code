package top.hengshare.interview.algorithm.leetcode;

import java.util.PriorityQueue;

/**
 * @author StevenYang
 * @description 返回数据流中的第k大个元素
 * @date  2020/7/19
 **/
public class KthLargest {

    private final PriorityQueue<Integer> q;
    private final int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        q = new PriorityQueue<>(k);
        for (int n : nums){
            add(n);
        }
    }

    public int add(int val) {
        if (q.size() < k) {
            q.offer(val);
        } else if (q.peek() < val) {
            q.poll();
            q.offer(val);
        }
        return q.peek();
    }
}
