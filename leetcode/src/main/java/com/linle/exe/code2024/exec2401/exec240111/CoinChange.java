package com.linle.exe.code2024.exec2401.exec240111;

import org.junit.Test;

import java.util.Arrays;
import java.util.logging.Level;

/**
 * @description: 322. 零钱兑换 middle
 * @author: chendeli
 * @date: 2024-01-11 11:06
 */
public class CoinChange {
    /**
     * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
     * <p>
     * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
     * <p>
     * 你可以认为每种硬币的数量是无限的。
     * <p>
     * 示例 1：
     * <p>
     * 输入：coins = [1, 2, 5], amount = 11
     * 输出：3
     * 解释：11 = 5 + 5 + 1
     * 示例 2：
     * <p>
     * 输入：coins = [2], amount = 3
     * 输出：-1
     * 示例 3：
     * <p>
     * 输入：coins = [1], amount = 0
     * 输出：0
     * <p>
     * 提示：
     * <p>
     * 1 <= coins.length <= 12
     * 1 <= coins[i] <= 231 - 1
     * 0 <= amount <= 10^4
     */
    @Test
    public void test() {
        int[] i = new int[]{186,419,83,408};
        int i1 = coinChange(i, 6249);
        System.out.println(i1);
    }

    /**
     * 解题思路： f(n) = f(n-1) + min(f(x))
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        Arrays.sort(coins);

        return getChange(coins,amount,coins.length);
    }

    private int getChange(int[] coins, int amount,int index) {
        if(amount == 0){

        }
        return 0;
    }
}
