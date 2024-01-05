package com.linle.exe.code2023.exec1213;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author chendeli
 * @Description: 有序数组的平方
 * @date 2022/12/13 14:01
 */
public class C977Test {
    /**给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。*/
    /**
     * 提示
     * 1 <= nums.length <= 104
     * -104 <= nums[i] <= 104
     * nums 已按 非递减顺序 排序
     *
     * 要求：
     * 请你设计时间复杂度为 O(n) 的算法解决本问题
     */
    @Test
    public void test977(){
        //题目思路 数组已排序，双向遍历比较
        int[] nums = {-32,-21,-9,1,4,54,76};
        int[] targetNums = new int[nums.length];
        int i = 0,j = nums.length -1;
        int index = nums.length -1 ;
        while(i < j){
            if(Math.abs(nums[j]) > Math.abs(nums[i])){
                targetNums[index--] = nums[j] * nums[j];
                j--;
            }else {
                targetNums[index--] = nums[i] * nums[i];
                i++;
            }
        }
        targetNums[index] = nums[j] * nums[j];
        Arrays.stream(targetNums).forEach(System.out::println);
    }

    public int[] sortedSquares(int[] nums) {
        return null;
    }
}
