package com.linle.exe.code2024.exec2402.exec240202;

import org.junit.Test;

import java.util.Map;
import java.util.Stack;

/**
 * @description: 84. 柱状图中最大的矩形 difficult
 * @author: chendeli
 * @date: 2024-02-02 17:00
 */
public class LargestRectangleArea {
    /**
     * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
     * <p>
     * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
     * <p>
     * 示例 1:
     * <p>
     * 输入：heights = [2,1,5,6,2,3]
     * 输出：10
     * 解释：最大的矩形为图中红色区域，面积为 10
     * 示例 2：
     * <p>
     * 输入： heights = [2,4]
     * 输出： 4
     * <p>
     * 提示：
     * <p>
     * 1 <= heights.length <=10^5
     * 0 <= heights[i] <= 104
     */
    @Test
    public void test() {
        largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3});
    }

    /**
     * 解题思路：
     * 1、
     *
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        int[] borderL = new int[len];
        int[] borderR = new int[len];
        Stack<Integer> sk = new Stack<>();
        for (int i = 0; i < len; i++) {
            while (!sk.isEmpty() && heights[i] < heights[sk.peek()]) {
                Integer pop = sk.pop();
                borderR[pop] = i;
            }
            borderL[i] = sk.isEmpty() ? -1 :sk.peek();
            sk.push(i);
        }
        int max = 0;
        for (int i = 0; i < len; i++) {
            int r = borderR[i] == 0 ? len : borderR[i];
            max = Math.max(max, (r - borderL[i] - 1) * heights[i]);
        }
        return max;
    }
}
