package com.linle.exe.code2024.exec2401.exec240110;

import org.junit.Test;

/**
 * @description: 64. 最小路径和 middle
 * @author: chendeli
 * @date: 2024-01-10 19:15
 */
public class MinPathSum {

    /**
     * 给定一个包含非负整数的   网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
     * <p>
     * 说明：每次只能向下或者向右移动一步。
     * <p>
     * 示例 1：
     * <p>
     * 输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
     * 输出：7
     * 解释：因为路径 1→3→1→1→1 的总和最小。
     * 示例 2：
     * <p>
     * 输入：grid = [[1,2,3],[4,5,6]]
     * 输出：12
     * <p>
     * 提示：
     * <p>
     * m == grid.length
     * n == grid[i].length
     * 1 <= m, n <= 200
     * 0 <= grid[i][j] <= 200
     */
    @Test
    public void test() {
        int[][] s = new int[][]{{1, 2, 3}, {4, 5, 6}};
        int i = minPathSum1(s);
        System.out.println(i);
    }

    /**
     * 解题思路：
     *
     * @param grid
     * @return
     */
    int m;
    int n;

    public int minPathSum(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int[][] minPath = new int[m][n];
        boolean[][] visitor = new boolean[m][n];
        minPath[0][0] = grid[0][0];
        visitor[0][0] = true;
        getPathSum(grid, minPath, 0, 0, visitor);
        return minPath[m - 1][n - 1];
    }

    private void getPathSum(int[][] grid, int[][] minPath, int col, int row, boolean[][] visitor) {
        if (col + 1 < m) {
            if (visitor[col + 1][row]) {
                minPath[col + 1][row] = Math.min(minPath[col + 1][row], minPath[col][row] + grid[col + 1][row]);
            } else {
                visitor[col + 1][row] = true;
                minPath[col + 1][row] = minPath[col][row] + grid[col + 1][row];
            }
            getPathSum(grid, minPath, col + 1, row, visitor);
        }
        if (row + 1 < n) {
            if (visitor[col][row + 1]) {
                minPath[col][row + 1] = Math.min(minPath[col][row + 1], minPath[col][row] + grid[col][row + 1]);
            } else {
                visitor[col][row + 1] = true;
                minPath[col][row + 1] = minPath[col][row] + grid[col][row + 1];
            }
            getPathSum(grid, minPath, col, row + 1, visitor);
        }
    }


    public int minPathSum1(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] minPath = new int[m][n];
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                if( i == 0 && j == 0){
//                    minPath[i][j] = grid[i][j] ;
//                    continue;
//                }else if(i == 0 ){
//                    minPath[i][j]  =  minPath[i][j -1] +grid[i][j];
//                }else if ( j == 0){
//                    minPath[i][j]  =  minPath[i-1][j ] +grid[i][j];
//                }else {
//                    minPath[i][j] = Math.min(minPath[i - 1][j] ,minPath[i][j - 1]) + grid[i][j];
//                }
//            }
//        }
//        return minPath[m-1][n-1];
        minPath[0][0] = grid[0][0];
        for (int i = 1; i < n; i++) {
            minPath[0][i] = minPath[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < m; i++) {
            minPath[i][0] = minPath[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                minPath[i][j] = Math.min(minPath[i][j - 1], minPath[i - 1][j]) + grid[i][j];
            }
        }
        return minPath[m - 1][n - 1];
    }

}
