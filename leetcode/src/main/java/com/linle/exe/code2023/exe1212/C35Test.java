package com.linle.exe.code2023.exe1212;

import org.junit.Test;

/**
 * @author chendeli
 * @Description: 搜索插入位置
 * @date 2022/12/12 11:19
 */
public class C35Test {

    /**
     * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     *
     * 请必须使用时间复杂度为 O(log n) 的算法。
     *
     * 提示：1 <= nums.length <= 104
     * -104 <= nums[i] <= 104
     * nums 为 无重复元素 的 升序 排列数组
     * -104 <= target <= 104
     */
    @Test
    public void test35() {
        int[] nums = {1,3,5,6}; int target = 2;
        //排序数组 复杂度log n 则确定二分法
        int left = 0;
        int right = nums.length-1;
        while(left < right){
            int middle = left + (right - left)/2;
            if(nums[middle] == target){
                System.out.println(middle);
            }else if ( nums[middle] > target){
                right = middle - 1;
            }else {
                left = middle + 1;
            }
        }
        System.out.println(left);
    }

    int searchInsert(int[] nums, int target) {
        return 0;
    }
}
