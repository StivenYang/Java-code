package top.hengshare.interview.algorithm.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class IslandPerimeterTest {

    @Test
    public void islandPerimeter() {
        int[][] arr = new int[][]{{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}};
        System.out.println(new IslandPerimeter().islandPerimeter(arr));
    }
}