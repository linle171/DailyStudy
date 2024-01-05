package com.linle.exe.code2023.exec1213;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author chendeli
 * @Description: 轮转数组
 * @date 2022/12/13 14:20
 */
public class C189Test {
    /**
     * 题目： 给你一个数组，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
     * <p>
     * 提示：
     * 1 <= nums.length <= 105
     * -231 <= nums[i] <= 231 - 1
     * 0 <= k <= 105
     *  
     * 进阶：
     * 尽可能想出更多的解决方案，至少有 三种 不同的方法可以解决这个问题。
     * 你可以使用空间复杂度为 O(1) 的 原地 算法解决这个问题吗？
     */

    @Test
    public void test189() {
        //解题思路 使用余数的方法 同时使用双指针一个在0位置 一个在k%length的位置
        int k = 4;
        int[] nums = {1,2,3,4,5,6};
        int length = nums.length;
        int i = 0;
        int preSource = nums[0];
        while (i < length) {
            int index = ((i + 1) * k) % length;
            int temp = nums[index];
            nums[index] = preSource;
            preSource = temp;
            i++;
        }

        Arrays.stream(nums).forEach(System.out::println);
    }


    /**
     * 数组翻转方法
     */
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start += 1;
            end -= 1;
        }
    }


    /**
     * 环绕方法
     * @param nums
     * @param k
     */
    public void rotate1(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        int count = gcd(k, n);
        for (int start = 0; start < count; ++start) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % n;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
            } while (start != current);
        }
    }

    /**
     * 最大公约数 欧几里得算法
     * @param x
     * @param y
     * @return
     */
    public int gcd(int x, int y) {
        return y > 0 ? gcd(y, x % y) : x;
    }


}
