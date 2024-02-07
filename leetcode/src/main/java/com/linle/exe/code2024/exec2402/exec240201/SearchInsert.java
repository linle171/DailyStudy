package com.linle.exe.code2024.exec2402.exec240201;

import org.junit.Test;

/**
 * @description: 35. 搜索插入位置 simple
 * @author: chendeli
 * @date: 2024-02-01 13:47
 */
public class SearchInsert {
    /**
     * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     *
     * 请必须使用时间复杂度为 O(log n) 的算法。
     *
     * 示例 1:
     *
     * 输入: nums = [1,3,5,6], target = 5
     * 输出: 2
     * 示例 2:
     *
     * 输入: nums = [1,3,5,6], target = 2
     * 输出: 1
     * 示例 3:
     *
     * 输入: nums = [1,3,5,6], target = 7
     * 输出: 4
     *
     * 提示:
     *
     * 1 <= nums.length <= 104
     * -104 <= nums[i] <= 104
     * nums 为 无重复元素 的 升序 排列数组
     * -104 <= target <= 104
     */
    @Test
    public void test(){
        int i = searchInsert(new int[]{1, 3, 5, 6}, 5);
        System.out.println(i);
    }

    /**
     *
     * 解题思路：
     * 1、
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        int len = nums.length;
        int l = 0;
        int r = len-1;
        while(l<=r) {
            int mid = l+ ((r-l) >> 1);
            if(target == nums[mid]){
                return mid;
            }else if(target > nums[mid]){
                l = mid +1;
                if(mid +1 == len || target < nums[l]){
                    return mid+1;
                }
            }else {
                r = mid -1;
                if(mid == 0 || target > nums[r]){
                    return mid;
                }
            }
        }
        return -1;
    }
}
