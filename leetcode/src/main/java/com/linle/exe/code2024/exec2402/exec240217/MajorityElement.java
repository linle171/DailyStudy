package com.linle.exe.code2024.exec2402.exec240217;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @description: 169. 多数元素 simple
 * @author: chendeli
 * @date: 2024-02-17 08:55
 */
public class MajorityElement {
    /**
     * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
     *
     * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
     *
     *
     *
     * 示例 1：
     *
     * 输入：nums = [3,2,3]
     * 输出：3
     * 示例 2：
     *
     * 输入：nums = [2,2,1,1,1,2,2]
     * 输出：2
     *
     *
     * 提示：
     * n == nums.length
     * 1 <= n <= 5 * 104
     * -109 <= nums[i] <= 109
     *
     *
     * 进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。
     */
    @Test
    public void test(){
        int[] i = new int[]{6,3,3};
        int temp = i[0];
        for (int j = 1; j < i.length; j++) {
            temp ^= i[j];
        }
        System.out.println(temp);

    }

    /**
     * 1、排序取中位数
     * @param nums
     * @return
     */
    public int majorityElement1(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    /**
     * 1、统计数字出现的次数
     * @param nums
     * @return
     */
    public int majorityElement2(int[] nums) {
        int target = nums.length/2 + 1;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = map.getOrDefault(nums[i], 0) + 1;
            if(temp >= target){
                return nums[i];
            }
            map.put(nums[i],temp);
        }
        return -1;
    }

    /**
     * Boyer-Moore 投票算法
     * @param nums
     * @return
     */
    public int majorityElement3(int[] nums) {
        int count = 0;
        int target = 0;
        for (int i = 0; i < nums.length; i++) {
            if(count == 0){
                target = nums[i];
            }
            count += (target == nums[i]) ? 1:-1;
        }
        return target;
    }
}
