package com.linle.exe.code2024.exec240107;

import org.junit.Test;

/**
 * @description: 69. x 的平方根  simple
 * @author: chendeli
 * @date: 2024-01-07 16:52
 */
public class MySqrt {
    /**
     * 给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
     * <p>
     * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
     * <p>
     * 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
     * <p>
     * 示例 1：
     * <p>
     * 输入：x = 4
     * 输出：2
     * 示例 2：
     * <p>
     * 输入：x = 8
     * 输出：2
     * 解释：8 的算术平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。
     * <p>
     * 提示： 0 <= x <= 231 - 1
     */
    @Test
    public void test() {
        int i = mySqrt(100);
        System.out.println(i);
    }

    /**
     * 解题思路：   条件：a^2 = b， 8 的算术平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去;
     * 结论：使用二分查找，找出第一个小于等于x^2值的数
     * 注意：存在越界的问题
     * 时间：logn
     *
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        if (x == 1 || x == 0) {
            return x;
        }
        return sqrt(x, 2, x);
    }

    private int sqrt(int x, int l, int r) {
        //取中间值
        int n = l + ((r-l)>>1);
        //为了避免越界 得到的c和n比较 若是c < n 那么递归（l,n-1） 若是 c>=n 说明n^2 >= x^2，那么若(n+1)^2 > x^2 则 n就是结果 否则 递归(n+1,r)
        int c = x / n;
        if (c >= n) {
            if (x - n * n < 2 * n + 1) {
                return n;
            } else {
                return sqrt(x,n+1,r) ;
            }
        } else {
           return  sqrt(x,l,n-1);
        }

    }
}
