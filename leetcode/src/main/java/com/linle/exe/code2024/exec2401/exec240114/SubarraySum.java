package com.linle.exe.code2024.exec2401.exec240114;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @description: 560. 和为 K 的子数组 middle
 * @author: chendeli
 * @date: 2024-01-14 23:02
 */
public class SubarraySum {
    /**
     * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
     *
     * 子数组是数组中元素的连续非空序列。
     *
     * 示例 1：
     *
     * 输入：nums = [1,1,1], k = 2
     * 输出：2
     * 示例 2：
     *
     * 输入：nums = [1,2,3], k = 3
     * 输出：2
     *
     * 提示：
     *
     * 1 <= nums.length <= 2 * 10^4
     * -1000 <= nums[i] <= 1000
     * -10^7 <= k <= 10^7
     */
    @Test
    public void test(){
        int[] i = new int[]{1,2,1,2,1};
        subarraySum(i,3);
    }

    /**
     * 解题思路：
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        int len = nums.length;
        int subCount = 0;
        for (int i = 0; i < len; i++) {
            int temp = 0 ;
            for (int j = i; j >= 0; j--) {
                temp += nums[j] ;
                if(temp == k){
                    subCount++;
                }
            }
        }
        return subCount;
    }

    /**
     * 解题思路：前缀和 + 哈希表优化  pre记录路径之和   哈希表记录前面出现和为n的个数    sum = pre + num[i]表示到i的总和  map.get(sum-k)中的sum-k在前面出现过得次数
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum1(int[] nums, int k) {
        int len = nums.length;
        int subCount = 0;
        int pre = 0;
        Map<Integer,Integer> map = new HashMap<Integer,Integer>(nums.length);
        map.put(0,1);
        for (int i = 0; i < len; i++) {
            pre += nums[i];
            if(map.containsKey(pre - k)){
                subCount += map.get(pre-k);
            }
            map.put(pre,map.getOrDefault(pre,0)+1);
        }
        return subCount;
    }
}
