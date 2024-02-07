package com.linle.exe.code2024.exec2402.exec240205;

import org.junit.Test;

import java.util.Arrays;

/**
 * @description: 416. 分割等和子集 middle
 * @author: chendeli
 * @date: 2024-02-05 15:05
 */
public class CanPartition {
    /**
     * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [1,5,11,5]
     * 输出：true
     * 解释：数组可以分割成 [1, 5, 5] 和 [11] 。
     * 示例 2：
     * <p>
     * 输入：nums = [1,2,3,5]
     * 输出：false
     * 解释：数组不能分割成两个元素和相等的子集。
     * <p>
     * 提示：
     * <p>
     * 1 <= nums.length <= 200
     * 1 <= nums[i] <= 100
     */
    @Test
    public void test() {
        canPartition(new int[]{1,2,3,4,5,6,7});
    }

    /**
     * 解题思路：
     * 1、
     *
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {
        Arrays.sort(nums);
        int lSum = 0;
        for (int i = 0; i < nums.length ; i++) {
            lSum += nums[i];
        }
        if(lSum % 2 != 0){
            return false;
        }
        return partition(nums, nums.length - 2,lSum/2, nums[nums.length - 1]);

    }

    private boolean partition(int[] nums, int index, int target, int rSum) {
        if (target == rSum) {
            return true;
        }
        if (rSum >target){
            return false;
        }
        for (int i = index; i >= 0; i--) {
            int r = rSum + nums[i];
            if(r > target){
                 continue;
            }
            if(partition(nums, i - 1, target, r)) {
                return true;
            }
        }
        return false;
    }


    public boolean canPartition1(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return false;
        }
        int sum = 0, maxNum = 0;
        for (int num : nums) {
            sum += num;
            maxNum = Math.max(maxNum, num);
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        if (maxNum > target) {
            return false;
        }
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            for (int j = target; j >= num; --j) {
                dp[j] |= dp[j - num];
            }
        }
        return dp[target];
    }


}
