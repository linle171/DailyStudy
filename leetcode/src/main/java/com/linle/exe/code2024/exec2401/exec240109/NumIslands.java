package com.linle.exe.code2024.exec2401.exec240109;

import org.checkerframework.checker.units.qual.C;
import org.junit.Test;

/**
 * @description: 200. 岛屿数量 middle
 * @author: chendeli
 * @date: 2024-01-09 15:37
 */
public class NumIslands {
    /**
     * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
     *
     * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
     *
     * 此外，你可以假设该网格的四条边均被水包围。
     *
     * 示例 1：
     *
     * 输入：grid = [
     *   ["1","1","1","1","0"],
     *   ["1","1","0","1","0"],
     *   ["1","1","0","0","0"],
     *   ["0","0","0","0","0"]
     * ]
     * 输出：1
     * 示例 2：
     *
     * 输入：grid = [
     *   ["1","1","0","0","0"],
     *   ["1","1","0","0","0"],
     *   ["0","0","1","0","0"],
     *   ["0","0","0","1","1"]
     * ]
     * 输出：3
     *
     * 提示：
     *
     * m == grid.length
     * n == grid[i].length
     * 1 <= m, n <= 300
     * grid[i][j] 的值为 '0' 或 '1'
     */
    @Test
    public void test() {
        char[][] clist = new char[2][1];
        clist[0][0] = '1';
        clist[1][0] = '1';
        int i = numIslands(clist);
        System.out.println(i);
    }

    /**
     * 解题思路：
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int row, int col) {
        int rowLen = grid.length;
        int colLen = grid[0].length;
        if(row >= rowLen || col >= colLen || row < 0 || col < 0 || grid[row][col] == '0'){
            return;
        }
        grid[row][col] = '0';
        dfs(grid,row,col+1);
        dfs(grid,row,col-1);
        dfs(grid,row-1,col);
        dfs(grid,row+1,col);
    }
}
