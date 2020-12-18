package top.hengshare.interview.algorithm.sort;

import org.junit.Test;

import java.util.Arrays;

public class QuickTest {

    private int[] arr = {1, 3, 5, 2, 11, 23, 34, 31, 12, 11};

    @Test
    public void testSort() {
        Quick quick = new Quick();
        quick.sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}