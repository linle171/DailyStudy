package com.linle.exe.code2024.exec240104;

import org.junit.Test;

/**
 * @description: 41题. 缺失的第一个正数
 * @author: chendeli
 * @date: 2024-01-04 21:18
 */
public class FirstMissingPositive {
    /**
     * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
     *
     * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
     *
     * 示例 1：
     *
     * 输入：nums = [1,2,0]
     * 输出：3
     * 示例 2：
     *
     * 输入：nums = [3,4,-1,1]
     * 输出：2
     * 示例 3：
     *
     * 输入：nums = [7,8,9,11,12]
     * 输出：1
     *
     * 提示：
     *
     * 1 <= nums.length <= 5 * 10^5
     * -2^31 <= nums[i] <= 2^31 - 1
     * @param nums
     * @return
     */
    public int firstMissingPositive(int[] nums) {
        int count = 0;
        for (int num : nums) {
            if(num > 0) {
                count++;
            }
        }
        int[] t = new int[count+2];
        for (int num : nums) {
            if(num > 0 && num < count+2) {
                t[num] = 1;
            }
        }
        for (int i = 1; i < t.length; i++) {
            if(t[i] == 0){
                return i;
            }
        }
        return 0;
    }
    @Test
    public void test() {
        int i = firstMissingPositive(new int[]{1,2,0});
        System.out.println(i);
    }

}
