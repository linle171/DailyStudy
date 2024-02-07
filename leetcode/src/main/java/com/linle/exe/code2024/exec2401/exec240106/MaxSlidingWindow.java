package com.linle.exe.code2024.exec2401.exec240106;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @description: 239. 滑动窗口最大值 difficult
 * @author: chendeli
 * @date: 2024-01-06 22:24
 */
public class MaxSlidingWindow {
    /**
     *
     * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
     *
     * 返回 滑动窗口中的最大值 。
     * 示例 1：
     *
     * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
     * 输出：[3,3,5,5,6,7]
     * 解释：
     * 滑动窗口的位置                最大值
     * ---------------               -----
     * [1  3  -1] -3  5  3  6  7       3
     *  1 [3  -1  -3] 5  3  6  7       3
     *  1  3 [-1  -3  5] 3  6  7       5
     *  1  3  -1 [-3  5  3] 6  7       5
     *  1  3  -1  -3 [5  3  6] 7       6
     *  1  3  -1  -3  5 [3  6  7]      7
     * 示例 2：
     *
     * 输入：nums = [1], k = 1
     * 输出：[1]
     * 提示：
     *
     * 1 <= nums.length <= 105
     * -104 <= nums[i] <= 104
     * 1 <= k <= nums.length
     */
    @Test
    public void test(){
        int[] nums =  {1,3,-1,-3,5,3,6,7};
        int k =3;
        maxSlidingWindow(nums,k);

    }

    /**
     * 解题思路：一个滑块框里面 假设index = i为最大值，那么滑块在i左边的值的时候，最大值还是i；所以i左边的值就不用在乎，以此类推
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] max = new int[nums.length-k+1];
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            while(!deque.isEmpty() && nums[i] > nums[deque.peekLast()]){
                deque.pollLast();
            }
            deque.offerLast(i);
        }
        max[0] = nums[deque.peekFirst()];
        for (int i = k; i < nums.length ; i++) {
            while(!deque.isEmpty() && nums[i] > nums[deque.peekLast()]){
                deque.pollLast();
            }
            deque.offerLast(i);
            if(deque.peekFirst() == i-k){
                deque.pollFirst();
            }
            max[i-k+1] = nums[deque.peekFirst()];
        }
        return max;
    }
}
