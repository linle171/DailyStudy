package com.linle.exe.code2024.exec2402.exec240203;

import org.junit.Test;

import java.util.PriorityQueue;

/**
 * @description: 215. 数组中的第K个最大元素 middle
 * @author: chendeli
 * @date: 2024-02-03 12:08
 */
public class FindKthLargest {
    /**
     * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
     *
     * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
     *
     * 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
     *
     * 示例 1:
     *
     * 输入: [3,2,1,5,6,4], k = 2
     * 输出: 5
     * 示例 2:
     *
     * 输入: [3,2,3,1,2,4,5,5,6], k = 4
     * 输出: 4
     *
     * 提示：
     *
     * 1 <= k <= nums.length <= 105
     * -104 <= nums[i] <= 104
     */
    @Test
    public void test(){
        findKthLargest(new int[]{3,2,1,5,6,4},2);
    }

    /**
     *
     * 解题思路：
     * 1、
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(k);
        for (int i = 0; i <nums.length; i++) {
            if(i<k){
                queue.add(nums[i]);
            }else {
                Integer peek = queue.peek();
                if(peek < nums[i]){
                    queue.poll();
                    queue.add(nums[i]);
                }
            }
        }
        return queue.peek();
    }
}
