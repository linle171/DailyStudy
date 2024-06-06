package com.linle.exe.code2024.exec2402.exec240203;

import org.junit.Test;

/**
 * @description: 55. 跳跃游戏 middle
 * @author: chendeli
 * @date: 2024-02-03 16:43
 */
public class Jump {
    /**
     * 给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。
     *
     * 每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:
     *
     * 0 <= j <= nums[i]
     * i + j < n
     * 返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。
     *
     * 示例 1:
     *
     * 输入: nums = [2,3,1,1,4]
     * 输出: 2
     * 解释: 跳到最后一个位置的最小跳跃数是 2。
     *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
     * 示例 2:
     *
     * 输入: nums = [2,3,0,1,4]
     * 输出: 2
     *
     * 提示:
     *
     * 1 <= nums.length <= 104
     * 0 <= nums[i] <= 1000
     * 题目保证可以到达 nums[n-1]
     */
    @Test
    public void test(){
        canJump(new int[]{2,3,1,1,4});
    }

    /**
     *
     * 解题思路：
     *
     * 1、
     * @param nums
     * @return
     */
    boolean[] isVisit ;
    int min = Integer.MAX_VALUE;
    public int canJump(int[] nums) {
        int n = nums.length;
        int steps = 0;
        int end = 0;
        int max = 0;
        for (int i = 0; i < n - 1; i++) {
            max = Math.max(max, i+nums[i]);
            if (i == end){
                end = max;
                steps++;
            }
        }

        return steps;

//        isVisit = new boolean[nums.length];
//        jump(nums,0,0);
//
//        return min;
    }




    /**
     *
     * 解题思路：
     * 1、记录第一步的最大步长 start = 0,end =0 maxStep1
     * 2、第二次循环记录 (start = end+1,end = maxStep1)中记录最大步长
     * 3、循环进行，最后一位的值就是最少步数次数
     * @param nums
     * @param index
     * @param count
     * @return
     */
    private boolean jump(int[] nums, int index, int count) {
        if(isVisit[index]){
            return false;
        }
        isVisit[index] = true;
        int num = nums[index];
        if(num + index >= nums.length -1){
            min = Math.min(min,count+1);
            return true;
        }
        if(num == 0 ){
            return false;
        }
        for (int i = num; i > 0; i--) {
            jump(nums, index + i, count+1);
        }
        return false;
    }


}
