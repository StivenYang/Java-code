package top.hengshare.interview.algorithm.leetcode;

/**
 * P463 岛屿的周长
 *
 * @author v_yangjiaheng_dxm
 * @date 2020/10/30 1:05 下午
 **/
public class IslandPerimeter {
    public int islandPerimeter(int[][] grid) {
        int sum = 0;
        int up, down, left, right;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    sum = sum + 4;
                    if (i - 1 >= 0) {
                        up = grid[i - 1][j];
                        if (up == 1) {
                            sum--;
                        }
                    }
                    if (i + 1 < grid.length) {
                        down = grid[i + 1][j];
                        if (down == 1) {
                            sum--;
                        }
                    }
                    if (j - 1 >= 0) {
                        left = grid[i][j - 1];
                        if (left == 1) {
                            sum--;
                        }
                    }
                    if (j + 1 < grid[0].length) {
                        right = grid[i][j + 1];
                        if (right == 1) {
                            sum--;
                        }
                    }
                }
            }
        }
        return sum;
    }
}
