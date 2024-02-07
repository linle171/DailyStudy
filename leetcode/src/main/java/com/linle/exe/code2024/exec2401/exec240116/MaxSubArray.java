package com.linle.exe.code2024.exec2401.exec240116;

import org.junit.Test;

/**
 * @description: 53. 最大子数组和 middle
 * @author: chendeli
 * @date: 2024-01-16 11:02
 */
public class MaxSubArray {
    /**
     * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     *
     * 子数组 是数组中的一个连续部分。
     *
     * 示例 1：
     *
     * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
     * 输出：6
     * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
     * 示例 2：
     *
     * 输入：nums = [1]
     * 输出：1
     * 示例 3：
     *
     * 输入：nums = [5,4,-1,7,8]
     * 输出：23
     *
     * 提示：
     *
     * 1 <= nums.length <= 105
     * -104 <= nums[i] <= 104
     *
     * 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。
     */
    @Test
    public void test(){
        maxSubArray2(new int[]{-1,-1,-2,-2});
    }

    /**
     * 解题思路：O(n^2) 这个方法超时
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int temp = 0;
            for (int j = i; j >= 0; j--) {
                temp += nums[j];
                maxSum = Math.max(maxSum,temp);
            }
        }
        return maxSum;
    }

    /**
     * 解题思路：
     * 里面indexMaxSum 保存在index下 最大的子串和数
     * 在 index+1下标下 indexMaxSum 若是大于0 说明对后面的数有贡献 则是算上下一个数的和数 indexMaxSum += nums[i]  否则indexMaxSum = nums[i]
     * maxSum则是统计过程中最大的和数
     * 时间复杂度 O(n)
     * @param nums
     * @return
     */
    public int maxSubArray1(int[] nums) {
        int maxSum = nums[0];
        int indexMaxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(indexMaxSum > 0){
                if(nums[i] >0){
                    maxSum =Math.max( indexMaxSum + nums[i],maxSum);
                }else {
                    maxSum = Math.max(indexMaxSum,maxSum);
                }
                indexMaxSum += nums[i];
            }else {
                maxSum = Math.max(Math.max(nums[i],indexMaxSum),maxSum);
                indexMaxSum = nums[i];
            }
        }
        return maxSum;
    }

    /**
     * 解题思路：基于上面优化 其实就是前缀和 和 当前数的比较
     *
     * 时间复杂度 O(n)
     * @param nums
     * @return
     */

    public int maxSubArray2(int[] nums) {
        int maxSum = 0;
        int indexMaxSum = nums[0];
        for (int i = 0; i < nums.length; i++) {
            maxSum = Math.max(maxSum+nums[i],nums[i]);
            indexMaxSum = Math.max(maxSum,indexMaxSum);
        }
        return indexMaxSum;
    }



}
