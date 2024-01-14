package com.linle.exe.code2024.exec2401.exec240113;

import org.junit.Test;

/**
 * @description: 42. 接雨水  difficult
 * @author: chendeli
 * @date: 2024-01-13 22:33
 */
public class Trap {
    /**
     * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
     *
     * 示例 1：
     *
     * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
     * 输出：6
     * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
     * 示例 2：
     *
     * 输入：height = [4,2,0,3,2,5]
     * 输出：9
     *
     * 提示：
     *
     * n == height.length
     * 1 <= n <= 2 * 104
     * 0 <= height[i] <= 105
     */
    @Test
    public void test(){
        int[] i = new int[]{4,2,0,3,2,5};
        trap(i);
    }

    /**
     * 解题思路：双指针 便利数组 查询左右最高的柱子 计算当前积水量
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int len = height.length;
        int[] rightHighest = new int[len];
        int sum = 0;
        rightHighest[len-1] = height[len-1];
        for (int i = len-2; i > 0; i--) {
            rightHighest[i] = Math.max(height[i],rightHighest[i+1]);
        }
        int leftHighest = 0;
        for (int i = 1; i < height.length; i++) {
            leftHighest = Math.max(leftHighest,height[i-1]);
            int min = Math.min(leftHighest, rightHighest[i]);
            if(min > height[i]){
                sum += min - height[i];
            }
        }
        return sum;
    }
}
