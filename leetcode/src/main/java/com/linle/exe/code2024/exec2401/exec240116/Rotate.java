package com.linle.exe.code2024.exec2401.exec240116;

import org.junit.Test;

import java.util.Arrays;

/**
 * @description: 189. 轮转数组 middle
 * @author: chendeli
 * @date: 2024-01-16 17:21
 */
public class Rotate {
    /**
     * 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
     *
     * 示例 1:
     *
     * 输入: nums = [1,2,3,4,5,6,7], k = 3
     * 输出: [5,6,7,1,2,3,4]
     * 解释:
     * 向右轮转 1 步: [7,1,2,3,4,5,6]
     * 向右轮转 2 步: [6,7,1,2,3,4,5]
     * 向右轮转 3 步: [5,6,7,1,2,3,4]
     * 示例 2:
     *
     * 输入：nums = [-1,-100,3,99], k = 2
     * 输出：[3,99,-1,-100]
     * 解释:
     * 向右轮转 1 步: [99,-1,-100,3]
     * 向右轮转 2 步: [3,99,-1,-100]
     *
     * 提示：
     *
     * 1 <= nums.length <= 10^5
     * -2^31 <= nums[i] <= 23^1 - 1
     * 0 <= k <= 10^5
     */
    @Test
    public void test(){
        rotate(new int[]{1,2,3,4,5,6,7},3);
    }


    /**
     *
     * @param nums  反转问题可以使用reverse，就是整体反转 在具备各自反转
     * @param k
     */
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k = k % len;
        int[] copy = Arrays.copyOf(nums, len - k);
        for (int i = 0; i < k; i++) {
            nums[i] = nums[i + len -k];
        }
        for (int i = k; i < len; i++) {
            nums[i] = copy[i-k];
        }
        System.out.println(1);
    }

    private void swapNum(int[] nums) {
        int r  = nums[nums.length-1];
        for (int i = nums.length-2; i >=0 ; i--) {
            nums[i+1] = nums[i];
        }
        nums[0] = r;
    }

}
