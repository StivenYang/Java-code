package top.hengshare.interview.algorithm.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class CanPlaceFlowersTest {

    @Test
    public void canPlaceFlowers() {
        int[] arr = new int[]{0, 1, 0};
        System.out.println(new CanPlaceFlowers().canPlaceFlowers(arr, 1));
    }
}