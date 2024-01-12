package com.linle.exe.code2024.exec2401.exec240111;

import com.linle.exe.code2024.exec2401.exec240108.MyAtoi;
import org.junit.Test;

import java.util.PrimitiveIterator;

/**
 * @description: 152. 乘积最大子数组 middle
 * @author: chendeli
 * @date: 2024-01-11 20:12
 */
public class MaxProduct {
    /**
     * 给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
     *
     * 测试用例的答案是一个 32-位 整数。
     *
     * 子数组 是数组的连续子序列。
     *
     * 示例 1:
     *
     * 输入: nums = [2,3,-2,4]
     * 输出: 6
     * 解释: 子数组 [2,3] 有最大乘积 6。
     * 示例 2:
     *
     * 输入: nums = [-2,0,-1]
     * 输出: 0
     * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
     *
     * 提示:
     *
     * 1 <= nums.length <= 2 * 104
     * -10 <= nums[i] <= 10
     * nums 的任何前缀或后缀的乘积都 保证 是一个 32-位 整数
     */
    @Test
    public void test(){
        int[] i = new int[]{-2,-3};
        int i1 = maxProduct(i);
        System.out.println(i1);
    }


    /**
     * 解题思路： 由于有负数，需要维护一个最大值集合和最小值集合
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        int length = nums.length;
        int[] maxF = new int[length];
        int[] minF = new int[length];
        System.arraycopy(nums, 0, maxF, 0, length);
        System.arraycopy(nums, 0, minF, 0, length);
        for (int i = 1; i < length; ++i) {
            maxF[i] = Math.max(maxF[i - 1] * nums[i], Math.max(nums[i], minF[i - 1] * nums[i]));
            minF[i] = Math.min(minF[i - 1] * nums[i], Math.min(nums[i], maxF[i - 1] * nums[i]));
        }
        int ans = maxF[0];
        for (int i = 1; i < length; ++i) {
            ans = Math.max(ans, maxF[i]);
        }
        return ans;
    }
}
