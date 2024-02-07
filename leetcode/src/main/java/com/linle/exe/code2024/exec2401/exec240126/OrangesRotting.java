package com.linle.exe.code2024.exec2401.exec240126;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * @description: 994. 腐烂的橘子 middle
 * @author: chendeli
 * @date: 2024-01-26 15:21
 */
public class OrangesRotting {
    /**
     * 在给定的 m x n 网格 grid 中，每个单元格可以有以下三个值之一：
     *
     * 值 0 代表空单元格；
     * 值 1 代表新鲜橘子；
     * 值 2 代表腐烂的橘子。
     * 每分钟，腐烂的橘子 周围 4 个方向上相邻 的新鲜橘子都会腐烂。
     *
     * 返回 直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1 。
     *
     * 示例 1：
     *
     * 输入：grid = [[2,1,1],[1,1,0],[0,1,1]]
     * 输出：4
     * 示例 2：
     *
     * 输入：grid = [[2,1,1],[0,1,1],[1,0,1]]
     * 输出：-1
     * 解释：左下角的橘子（第 2 行， 第 0 列）永远不会腐烂，因为腐烂只会发生在 4 个方向上。
     * 示例 3：
     *
     * 输入：grid = [[0,2]]
     * 输出：0
     * 解释：因为 0 分钟时已经没有新鲜橘子了，所以答案就是 0 。
     *
     * 提示：
     *
     * m == grid.length
     * n == grid[i].length
     * 1 <= m, n <= 10
     * grid[i][j] 仅为 0、1 或 2
     */
    @Test
    public void test(){}


    int[] dr = new int[]{-1,1,1,-1};
    int[] dc = new int[]{0,-1,1,1};
    /**
     *
     * 解题思路：
     * @param grid
     * @return
     */
    int ans = 0;
    public int orangesRotting(int[][] grid) {
        int c = grid.length;
        int r = grid[0].length;
        Deque<Integer> deque = new ArrayDeque<>();
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < c; i++) {
            for (int j = 0; j < r; j++) {
                if(grid[i][j] == 2){
                    int code = i*r + j;
                    deque.add(code);
                    map.put(code,0);
                }
            }
        }

        while(!deque.isEmpty()){
            Integer pop = deque.pop();
            int rT = pop%r;
            int cT = (pop-rT)/r;
            for (int k = 0; k < 4; k++) {
                rT = rT + dr[k];
                cT = cT + dc[k];
                if(0 <= rT && 0<=cT && r > rT && c>cT && grid[cT][rT] == 1){
                    grid[cT][rT] = 2;
                    int code = cT*r + rT;
                    deque.add(code);
                    map.put(code,map.get(pop)+1);
                    ans = Math.max(ans,map.get(code));
                }
            }

        }
        for (int i = 0; i < c; i++) {
            for (int j = 0; j < r; j++) {
                if(grid[i][j] == 1){
                    return -1;
                }
            }
        }
        return ans;

    }

    /***********************更高效的方法********************************/

    /**
     *
     * 解题思路：
     * 1、先记录所有为2的坐标 deque
     * 2、循环遍历deque 判断四个方向的节点为1  则加入deque 该节点进入下一次循环 同时设置该节点为2
     * 3、结束判断数组内是否有1，有则返回-1 无则返回循环次数
     * @param grid
     * @return
     */
    public int orangesRotting1(int[][] grid) {
        Deque<int[]> dq = new ArrayDeque<>();
        int[][] dirs = {
                {1, 0}, {-1,0 }, {0, 1}, {0, -1}
        };
        int m = grid.length, n = grid[0].length, count = 0, round = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) count++;
                else if (grid[i][j] == 2) dq.add(new int[]{i, j});
            }
        }

        while (count > 0 && !dq.isEmpty()) {
            round++;
            int size = dq.size();
            for (int i = 0; i < size; i++) {
                int[] orange = dq.poll();
                int x = orange[0], y = orange[1];
                for (int[] dir : dirs) {
                    int nextX = x + dir[0];
                    int nextY = y + dir[1];
                    if (nextX < 0 || nextX >= m || nextY < 0 || nextY >= n) continue;
                    if (grid[nextX][nextY] == 1) {
                        grid[nextX][nextY] = 2;
                        count--;
                        dq.add(new int[] {nextX, nextY});
                    }
                }
            }
        }

        if(count > 0) return -1;
        else return round;
    }

}
