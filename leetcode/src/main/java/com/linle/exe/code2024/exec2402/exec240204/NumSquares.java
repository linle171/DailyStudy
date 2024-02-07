package com.linle.exe.code2024.exec2402.exec240204;

import org.junit.Test;

import java.util.Arrays;

/**
 * @description: 279. 完全平方数 middle
 * @author: chendeli
 * @date: 2024-02-04 10:16
 */
public class NumSquares {
    /**
     * 给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
     * <p>
     * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
     * <p>
     * 示例 1：
     * <p>
     * 输入：n = 12
     * 输出：3
     * 解释：12 = 4 + 4 + 4
     * 示例 2：
     * <p>
     * 输入：n = 13
     * 输出：2
     * 解释：13 = 4 + 9
     * <p>
     * 提示：
     * <p>
     * 1 <= n <= 10^4
     */
    @Test
    public void test() {
        double sqrt = Math.sqrt(13);
        int round = (int) Math.round(sqrt);
        System.out.println(round);
        numSquares(13);
    }

    /**
     * 解题思路：
     * 1、
     *
     * @param n
     * @return
     */
    public int numSquares(int n) {
        int[] temp = new int[n + 1];
        Arrays.fill(temp,1,n+1,Integer.MAX_VALUE);
        double sqrt = Math.sqrt(n);
        int round = (int) Math.floor(sqrt);
        //初始化temp数组
        for (int i = 1; i < round+1; i++) {
            temp[i * i] = 1;
        }
        for (int i = 2; i < n + 1; i++) {
            if (temp[i] == 1) {
                continue;
            }
            sqrt = Math.sqrt(i);
            round = (int) Math.floor(sqrt);
            for (int j = round; j > 0; j--) {
                temp[i] = Math.min(temp[i],temp[j*j] + temp[i-j*j]);
            }
        }
        return temp[n];
    }

    public int numSquares1(int n) {
        if (isPerfectSquare(n)) {
            return 1;
        }
        if (checkAnswer4(n)) {
            return 4;
        }
        for (int i = 1; i * i <= n; i++) {
            int j = n - i * i;
            if (isPerfectSquare(j)) {
                return 2;
            }
        }
        return 3;
    }

    // 判断是否为完全平方数
    public boolean isPerfectSquare(int x) {
        int y = (int) Math.sqrt(x);
        return y * y == x;
    }

    // 判断是否能表示为 4^k*(8m+7)
    public boolean checkAnswer4(int x) {
        while (x % 4 == 0) {
            x /= 4;
        }
        return x % 8 == 7;
    }


    //推荐
    public int numSquares2(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, n+1);
        dp[0] = 0;
        for(int i=1; i*i<=n; i++){ //i充当数组元素，直接从1开始
            for(int j=i*i; j<=n; j++){ //i*i就是重量
                dp[j] = Math.min(dp[j], 1+dp[j-i*i]);
            }
        }
        return dp[n];
    }
}
