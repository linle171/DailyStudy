package com.linle.exe.code2023.exec1225;

import org.junit.Test;

import java.util.BitSet;

/**
 * @description: leetcode 第300题 动规
 * 首先，我们来看，什么是“一个模型”？它指的是动态规划适合解决的问题的模型。我把这个模型定义为“多阶段决策最优解模型”。
 * 我们一般是用动态规划来解决最优问题。而解决问题的过程，需要经历多个决策阶段。每个决策阶段都对应着一组状态。然后我们寻找一组决策序列，经过这组决策序列，能够产生最终期望求解的最优值。
 * 现在，我们再来看，什么是“三个特征”？它们分别是最优子结构、无后效性和重复子问题。
 * @author: chendeli
 * @date: 2023-12-25 11:07
 */
public class C300 {
    /**
     * 问题描述
     * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
     * <p>
     * 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
     * <p>
     * 示例 1：
     * 输入：nums = [10,9,2,5,3,7,101,18]
     * 输出：4
     * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
     * 示例 2：
     * 输入：nums = [0,1,0,3,2,3]
     * 输出：4
     * 示例 3：
     * 输入：nums = [7,7,7,7,7,7,7]
     * 输出：1
     * <p>
     * 提示：
     * <p>
     * 1 <= nums.length <= 2500
     * -104 <= nums[i] <= 104
     * <p>
     * 进阶：
     * <p>
     * 你能将算法的时间复杂度降低到 O(n log(n)) 吗?
     */
    @Test
    public void testLengthOfLIS() {
        /**
         * 解题思路
         *方法一：动归
         *f(i) = |f(j)|max + 1   0<= j <i nums[i] > nums[j]
         *
         * 方法二：动归 + 二分查找
         */
        int[] nums = new int[]{3, 5, 6, 2, 5, 4, 19, 5, 6, 7, 12};

//        int result = lengthOfLIS1(nums);
        int result = lengthOfLIS2(nums);
        System.out.println(result);
    }

    /*
     * lenStatus[] index是子集的长度，值表示当前长度下最小的值
     * 1、nums[i] > lenStatus[len]  则长度加一，lenStatus[++len] = nums[i]
     * 2、nums[i] < lenStatus[len]  从二分查找第一个比nums[i] 小的值
     */
    private int lengthOfLIS2(int[] nums) {
        int length = nums.length;
        int[] lenStatus = new int[length];
        lenStatus[1] = nums[0];
        int len = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > lenStatus[len]) {
                lenStatus[++len] = nums[i];
            } else {
                int l = 1, r = len, pos = 0;
                while (l <= r) {
                    int mid = (l + r) >> 1;
                    if (nums[i] > lenStatus[mid]) {
                        pos = mid;
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
                lenStatus[pos + 1] = nums[i];
            }
        }
        return len;
    }

    int lengthOfLIS1(int[] nums) {
        BitSet bitSet = new BitSet(10);
        int length = nums.length;
        int[] status = new int[length];
        status[0] = 1;
        int maxLen = 1;
        for (int i = 1; i < nums.length; i++) {
            status[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    status[i] = Math.max(status[i], status[j] + 1);
                }
            }
            maxLen = Math.max(maxLen, status[i]);
        }
        return maxLen;
    }
}
