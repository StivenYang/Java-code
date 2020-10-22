package top.hengshare.interview.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * P763 划分字母区间
 *
 * @author v_yangjiaheng_dxm
 * @date 2020/10/22 2:24 下午
 **/
public class P763 {
    public static List<Integer> partitionLabels(String S) {
        int[] last = new int[26];
        int len = S.length();
        for (int i = 0; i < len; i++) {
            last[S.charAt(i) - 'a'] = i;
        }
        List<Integer> partitions = new ArrayList<>();
        int start = 0, end = 0;
        for (int i = 0; i < len; i++) {
            end = Math.max(end, last[S.charAt(i) - 'a']);
            if (end == i) {
                partitions.add(end - start + 1);
                start = end + 1;
            }
        }
        return partitions;
    }

    public static void main(String[] args) {
        System.out.println(partitionLabels("ababcde"));
    }
}
