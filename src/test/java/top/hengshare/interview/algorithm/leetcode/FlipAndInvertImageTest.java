package top.hengshare.interview.algorithm.leetcode;

import org.junit.Test;

import java.util.Arrays;

public class FlipAndInvertImageTest {

    @Test
    public void flipAndInvertImage() {
        int[][] arr = new int[][]{{1, 1, 0}, {1, 0, 1}, {0, 0, 0}};

        for (int[] ints : new FlipAndInvertImage().flipAndInvertImage(arr)) {
            System.out.println(Arrays.toString(ints));
        }
    }
}