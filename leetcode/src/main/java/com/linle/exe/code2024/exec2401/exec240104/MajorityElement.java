package com.linle.exe.code2024.exec2401.exec240104;

/**
 * @description: 169题. 多数元素
 * @author: chendeli
 * @date: 2024-01-04 16:08
 */

import org.junit.Test;

import java.util.Arrays;

/**
 *
 * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,2,3]
 * 输出：3
 * 示例 2：
 * <p>
 * 输入：nums = [2,2,1,1,1,2,2]
 * 输出：2
 * <p>
 * 提示：
 * n == nums.length
 * 1 <= n <= 5 * 104
 * -10^9 <= nums[i] <= 10^9
 * <p>
 * 进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。
 */
public class MajorityElement {

    @Test
    public void test() {
        int[] t = {3, 2, 3, 8, 8, 8, 8};
//        int i = majorityElement(t);
        int i = majorityElement1(t);
        System.out.println(i);
    }

    /**
     * 排序 时间复杂度nlogn
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length >> 1];
    }

    /**
     * 时间复杂度为n，还是基于大于半数的特性
     * @param nums
     * @return
     */
    public int majorityElement1(int[] nums) {
        int count = 0;
        int num = -1;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                num = nums[i];
            }
            count += (nums[i] == num) ? 1 : -1;
        }
        return num;
    }

}
