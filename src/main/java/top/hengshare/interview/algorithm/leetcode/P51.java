package top.hengshare.interview.algorithm.leetcode;

import java.util.*;

/**
 * P51 N皇后问题
 *
 * @author yjh
 * @since 2020/11/1
 */
public class P51 {
    public static List<List<String>> solveNQueens(int n) {
        int[] queues = new int[n];
        List<List<String>> solutions = new ArrayList<>();
        Arrays.fill(queues, -1);
        Set<Integer> columns = new HashSet<>();
        Set<Integer> diagonals1 = new HashSet<>();
        Set<Integer> diagonals2 = new HashSet<>();
        backtrack(solutions, queues, n, 0, columns, diagonals1, diagonals2);
        return solutions;
    }

    private static void backtrack(List<List<String>> solutions, int[] queues, int n, int row, Set<Integer> columns, Set<Integer> diagonals1, Set<Integer> diagonals2) {
        if (row == n) {
            List<String> board = generateBoard(queues, n);
            solutions.add(board);
        } else {
            for (int i = 0; i < n; i++) {
                if (columns.contains(i)) {
                    continue;
                }
                int diagonal1 = row - i;
                if (diagonals1.contains(diagonal1)) {
                    continue;
                }
                int diagonal2 = row + i;
                if (diagonals2.contains(diagonal2)) {
                    continue;
                }
                queues[row] = i;
                columns.add(i);
                diagonals1.add(diagonal1);
                diagonals2.add(diagonal2);
                backtrack(solutions, queues, n, row+1, columns, diagonals1, diagonals2);
                queues[row] = -1;
                columns.remove(i);
                diagonals1.remove(diagonal1);
                diagonals2.remove(diagonal2);
            }
        }
    }

    private static List<String> generateBoard(int[] queues, int n) {
        List<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[queues[i]] = 'Q';
            board.add(new String(row));
        }
        return board;
    }

    public static void main(String[] args) {
        System.out.println(solveNQueens(5));
    }

    /************************************************************************/

    public List<List<String>> solveNQueens1(int n) {
        int[] queues = new int[n];
        Arrays.fill(queues, -1);
        List<List<String>> solutions = new ArrayList<>();
        solve(solutions, queues, n, 0, 0, 0, 0);
        return solutions;
    }

    private void solve(List<List<String>> solutions, int[] queues, int n, int row, int column, int diagonal1, int diagonal2) {
        if (row == n) {
            List<String> board = generateBoard1(queues, n);
            solutions.add(board);
        }else {
            for (int i = 0; i < n; i++) {

            }
        }
    }


}
