package com.linle.exe.code2024.exec2402.exec240201;

import org.junit.Test;

/**
 * @description: 33. 搜索旋转排序数组 middle
 * @author: chendeli
 * @date: 2024-02-01 20:38
 */
public class Search {
    /**
     * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]
     * （下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
     * <p>
     * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
     * <p>
     * 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [4,5,6,7,0,1,2], target = 0
     * 输出：4
     * 示例 2：
     * <p>
     * 输入：nums = [4,5,6,7,0,1,2], target = 3
     * 输出：-1
     * 示例 3：
     * <p>
     * 输入：nums = [1], target = 0
     * 输出：-1
     * <p>
     * 提示：
     * <p>
     * 1 <= nums.length <= 5000
     * -10^4 <= nums[i] <= 10^4
     * nums 中的每个值都 独一无二
     * 题目数据保证 nums 在预先未知的某个下标上进行了旋转
     * -10^4 <= target <= 10^4
     */
    @Test
    public void test() {
//        int search = search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0);
//        int search = search(new int[]{4,5,6,7,8,1,2,3}, 8);
        int search = search(new int[]{3,1}, 1);
        System.out.println(search);
    }


    /**
     * 解题思路：
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        //先通过二分查找找到最小值的坐标
        int len = nums.length;
        int l = 0, r = len - 1;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (target > nums[mid]) {
                if(target > nums[r] && nums[mid]<=nums[r]){
                    r = mid -1;
                    continue;
                }
                l = mid + 1;

            } else if (target < nums[mid]) {
                if(target < nums[l] && nums[mid] >= nums[l]){
                    l = mid + 1;
                    continue;
                }
                r = mid -1;

            } else {
                return mid;
            }
        }
        return -1;
    }

}
