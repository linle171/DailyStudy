package com.linle.exe.code2024.exec240107;

import org.junit.Test;

/**
 * @description: 70. 爬楼梯 simple
 * @author: chendeli
 * @date: 2024-01-07 00:10
 */
public class ClimbStairs {
    /**
     * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
     *
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     *
     *
     *
     * 示例 1：
     *
     * 输入：n = 2
     * 输出：2
     * 解释：有两种方法可以爬到楼顶。
     * 1. 1 阶 + 1 阶
     * 2. 2 阶
     * 示例 2：
     *
     * 输入：n = 3
     * 输出：3
     * 解释：有三种方法可以爬到楼顶。
     * 1. 1 阶 + 1 阶 + 1 阶
     * 2. 1 阶 + 2 阶
     * 3. 2 阶 + 1 阶
     *
     *
     * 提示：
     *
     * 1 <= n <= 45
     */
    @Test
    public void test(){
        int i = climbStairs1(45);
        System.out.println(i);
    }

    /**
     * 解题思路：动态规划
     * f(n) = f(n-1) + f(n-2)
     * 终止条件 n = 1 return 1 ; n = 0 return 0;
     * @param n
     * @return
     */
    //递归的方法，可能的结果层级很高会导致栈的内存溢出
    public int climbStairs(int n) {
        if ( n == 1){
            return 1;
        }
        if( n == 2 ){
            return 2;
        }
        return climbStairs(n-1) + climbStairs(n-2);
    }

    //使用动态规划，记录每次的结果，这样后面的计算就不需要重复的计算
    public int climbStairs1(int n) {
        if ( n == 1){
            return 1;
        }
        if( n == 2 ){
            return 2;
        }
        int[] visitor = new int[n+1];
        visitor[1] = 1;
        visitor[2] = 2;
        for (int i = 3; i < n+1; i++) {
            visitor[i] = visitor[i-1] + visitor[i-2];
        }
        return visitor[n];
    }
}
