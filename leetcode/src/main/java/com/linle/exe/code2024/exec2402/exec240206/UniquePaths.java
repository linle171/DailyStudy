package com.linle.exe.code2024.exec2402.exec240206;

import org.junit.Test;

/**
 * @description: 62. 不同路径 middle
 * @author: chendeli
 * @date: 2024-02-06 15:25
 */
public class UniquePaths {
    /**
     * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
     *
     * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
     *
     * 问总共有多少条不同的路径？
     *
     * 示例 1：
     *
     * 输入：m = 3, n = 7
     * 输出：28
     * 示例 2：
     *
     * 输入：m = 3, n = 2
     * 输出：3
     * 解释：
     * 从左上角开始，总共有 3 条路径可以到达右下角。
     * 1. 向右 -> 向下 -> 向下
     * 2. 向下 -> 向下 -> 向右
     * 3. 向下 -> 向右 -> 向下
     * 示例 3：
     *
     * 输入：m = 7, n = 3
     * 输出：28
     * 示例 4：
     *
     * 输入：m = 3, n = 3
     * 输出：6
     *
     * 提示：
     *
     * 1 <= m, n <= 100
     * 题目数据保证答案小于等于 2 * 109
     */
    @Test
    public void test(){
        uniquePaths(3,7);
    }

    /**
     *
     * 解题思路：
     * 1、
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        int[][] isVisit = new int[m+1][n+1];
        isVisit[m][n-1] = 1;
        dp(isVisit,m-1,n-1);
        return isVisit[0][0];
    }

    private void dp(int[][] isVisit,int m, int n) {
        if(m<0 && n<0){
            return;
        }
        if(m>=0) {
            int k = Math.max(n, 0);
            for (int i = m ; i >= 0; i--) {
                isVisit[i][k] = isVisit[i + 1][k] + isVisit[i][k + 1];
            }
        }
        if(n>=0) {
            int k = Math.max(m, 0);
            for (int i = n; i >= 0; i--) {
                isVisit[k][i] = isVisit[k][i+1] + isVisit[k+1][i];
            }
        }
        dp(isVisit,m-1 ,n-1);
    }
}
