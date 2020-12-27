package top.hengshare.interview.algorithm.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class ContainsNearbyDuplicateTest {

    @Test
    public void containsNearbyDuplicate() {
        int[] arr = new int[]{1, 2, 3, 1, 2, 3};
        System.out.println(new ContainsNearbyDuplicate().containsNearbyDuplicate(arr, 2));
    }
}