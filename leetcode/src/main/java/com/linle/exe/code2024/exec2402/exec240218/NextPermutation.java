package com.linle.exe.code2024.exec2402.exec240218;

import org.junit.Test;

import java.util.Arrays;

/**
 * @description: 31. 下一个排列 middle
 * @author: chendeli
 * @date: 2024-02-18 11:05
 */
public class NextPermutation {
    /**
     * 整数数组的一个 排列  就是将其所有成员以序列或线性顺序排列。
     *
     * 例如，arr = [1,2,3] ，以下这些都可以视作 arr 的排列：[1,2,3]、[1,3,2]、[3,1,2]、[2,3,1] 。
     * 整数数组的 下一个排列 是指其整数的下一个字典序更大的排列。更正式地，如果数组的所有排列根据其字典顺序从小到大排列在一个容器中，那么数组的
     * 下一个排列 就是在这个有序容器中排在它后面的那个排列。如果不存在下一个更大的排列，那么这个数组必须重排为字典序最小的排列（即，其元素按升序排列）。
     *
     * 例如，arr = [1,2,3] 的下一个排列是 [1,3,2] 。
     * 类似地，arr = [2,3,1] 的下一个排列是 [3,1,2] 。
     * 而 arr = [3,2,1] 的下一个排列是 [1,2,3] ，因为 [3,2,1] 不存在一个字典序更大的排列。
     * 给你一个整数数组 nums ，找出 nums 的下一个排列。
     *
     * 必须 原地 修改，只允许使用额外常数空间。
     *
     * 示例 1：
     *
     * 输入：nums = [1,2,3]
     * 输出：[1,3,2]
     * 示例 2：
     *
     * 输入：nums = [3,2,1]
     * 输出：[1,2,3]
     * 示例 3：
     *
     * 输入：nums = [1,1,5]
     * 输出：[1,5,1]
     *
     * 提示：
     *
     * 1 <= nums.length <= 100
     * 0 <= nums[i] <= 100
     */
    @Test
    public void test(){
        nextPermutation(new int[]{1,5,1});
    }

    /**
     *
     * 解题思路：
     * 1、从后往前查找第一个升序的坐标 i
     * 2、然后 查找以后面最后一个比nums[i] 大的坐标，进行替换
     * 3、最后将 i+1到nums.length-1坐标进行升序排序
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        if(nums.length == 1){
            return;
        }
        int l = 0,r = nums.length-1;
        for (int i = nums.length-2; i >= 0; i--) {
            if(nums[i] < nums[i+1]){
                for (int j = i+1; j < nums.length ; j++) {
                    if(nums[j] <= nums[i]){
                        swapNum(nums,i,j-1);
                        break;
                    }
                    if(j == nums.length-1){
                        swapNum(nums,i,j);
                    }
                }
                l = i+1;
                break;
            }
        }
        while(l<r){
            swapNum(nums,l,r);
            l++;
            r--;
        }
        System.out.println(11);
    }

    private void swapNum(int[] nums, int l, int r) {
        int t = nums[l]^nums[r];
        nums[l] = t^nums[l];
        nums[r] = t^nums[r];
    }
}
