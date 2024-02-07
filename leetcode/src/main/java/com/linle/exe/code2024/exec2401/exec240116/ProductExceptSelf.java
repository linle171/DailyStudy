package com.linle.exe.code2024.exec2401.exec240116;

import org.junit.Test;

/**
 * @description: 238. 除自身以外数组的乘积 middle
 * @author: chendeli
 * @date: 2024-01-16 17:51
 */
public class ProductExceptSelf {
    /**
     * 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
     *
     * 题目数据保证数组nums之中任意元素的全部前缀元素和后缀的乘积都在32位整数范围内。
     *
     * 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
     *
     * 示例 1:
     *
     * 输入: nums = [1, 2,3,4]
     * 输出: [24,12,8,6]
     * 示例 2:
     *
     * 输入: nums = [-1,1,0,-3,3]
     * 输出: [0,0,9,0,0]
     *
     * 提示：
     *
     * 2 <= nums.length <= 10^5
     * -30 <= nums[i] <= 30
     * 保证数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内
     *
     * 进阶：你可以在 O(1) 的额外空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组 不被视为 额外空间。）
     */
    @Test
    public void test(){
        productExceptSelf(new int[]{1, 2,3,4});
    }


    /**
     * 解题思路:
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] answer = new int[len];
        int l = 1;
        answer[0]=1;
        while(l<len){
            answer[l]= answer[l-1]*nums[l-1];
            l++;
        }
        int r = len-2;
        int suf = nums[len-1];
        while(r>=0){
            answer[r] = answer[r]*suf;suf *= nums[r];r--;
        }
        return answer;
    }
}
