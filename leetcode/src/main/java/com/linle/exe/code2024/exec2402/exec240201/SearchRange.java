package com.linle.exe.code2024.exec2402.exec240201;

import org.junit.Test;

/**
 * @description: 34. 在排序数组中查找元素的第一个和最后一个位置 middle
 * @author: chendeli
 * @date: 2024-02-01 15:46
 */
public class SearchRange {
    /**
     * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
     *
     * 如果数组中不存在目标值 target，返回 [-1, -1]。
     *
     * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
     *
     * 示例 1：
     *
     * 输入：nums = [5,7,7,8,8,10], target = 8
     * 输出：[3,4]
     * 示例 2：
     *
     * 输入：nums = [5,7,7,8,8,10], target = 6
     * 输出：[-1,-1]
     * 示例 3：
     *
     * 输入：nums = [], target = 0
     * 输出：[-1,-1]
     *
     * 提示：
     *
     * 0 <= nums.length <= 10^5
     * -10^9 <= nums[i] <= 10^9
     * nums 是一个非递减数组
     * -10^9 <= target <= 10^9
     */
    @Test
    public void test(){
//        searchRange(new int[]{5,7,7,8,8,10},8);
        searchRange(new int[]{2,2},2);
    }


    /**
     *
     * 解题思路：
     * 1、
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        int l = 0;
        int r = len-1;
        //查找最左边的位置
        int position = -1;
        while(l<=r){
            int mid = l + ((r-l)>>1);
            if(target > nums[mid]){
                l = mid +1;
            }else if (target < nums[mid]){
                r = mid -1;
            }else {
                if(mid == 0 || nums[mid-1] < target){
                    position = mid;
                    break;
                }
                r = mid -1;
            }
        }
        int[] result = new int[2];
        result[0] = position;
        if(position == -1){
            result[1] = -1;
            return result;
        }
        r = len-1;
        while(position<=r){
            int mid = l + ((r-l)>>1);
            if(target > nums[mid]){
                l = mid +1;
            }else if (target < nums[mid]){
                r = mid -1;
            }else {
                if(mid == len-1 || nums[mid+1] > target){
                    position = mid;
                    break;
                }
                l = mid +1;
            }
        }
        result[1] = position;
        return result;
    }
}
