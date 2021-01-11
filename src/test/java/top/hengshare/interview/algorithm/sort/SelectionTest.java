package top.hengshare.interview.algorithm.sort;

import org.junit.Test;

import java.util.Arrays;

public class SelectionTest {

    private int[] arr = {1, 3, 5, 2, 11, 23, 34, 31, 12, 11};

    @Test
    public void testSort() {
        Selection selection = new Selection();
        selection.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void testSort1(){
        Selection selection = new Selection();
        selection.sort1(arr);
        System.out.println(Arrays.toString(arr));
    }
}