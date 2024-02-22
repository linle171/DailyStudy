package com.linle.exe.code2024.exec2402.exec240203;

import org.junit.Test;

/**
 * @description: 55. 跳跃游戏 middle
 * @author: chendeli
 * @date: 2024-02-03 16:43
 */
public class CanJump {
    /**
     * 给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。
     *
     * 判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。
     *
     * 示例 1：
     *
     * 输入：nums = [2,3,1,1,4]
     * 输出：true
     * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
     * 示例 2：
     *
     * 输入：nums = [3,2,1,0,4]
     * 输出：false
     * 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
     *
     * 提示：
     *
     * 1 <= nums.length <= 104
     * 0 <= nums[i] <= 105
     */
    @Test
    public void test(){
        canJump2(new int[]{2,3});
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
    public boolean canJump(int[] nums) {
        isVisit = new boolean[nums.length];
        return jump(nums,0);
    }

    private boolean jump(int[] nums, int index) {
        if(isVisit[index]){
            return false;
        }
        isVisit[index] = true;
        int num = nums[index];
        if(num + index >= nums.length -1){
            return true;
        }
        if(num == 0 ){
            return false;
        }
        for (int i = num; i > 0; i--) {
            if(jump(nums, index + i)){
                return true;
            }
        }
        return false;
    }

    public boolean canJump1(int[] nums) {
        int reach = 0;
        for (int i = 0; i < nums.length; i++) {
            if(i <= reach){
                reach = Math.max(reach,i+nums[i]);
                if(reach >= nums.length-1){
                    return true;
                }
                continue;
            }
            break;
        }
        return false;
    }

    public int canJump2(int[] nums) {
        Integer[] result = new Integer[nums.length];
        result[0] = 0;
        int dis = 0;
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i-1];
            dis = Math.max(dis,num + i);
            for (int j = i; j < Math.min( num+i,nums.length); j++) {
              result[j] = result[j] == null ? result[i-1] + 1 : Math.min( result[j],result[i-1] + 1);
            }
            if(dis > nums.length-1){
                return result[nums.length-1];
            }
        }
        return result[nums.length-1];
    }



    public boolean canJump4(int[] nums) {
        boolean[] isVisit = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if(isVisit[i]){
                continue;
            }
            isVisit[i] = true;
            int max = nums[i];
            int k = 0;
            for (int j = 1; j < nums[i]+1; j++) {
                isVisit[j] = true;
                if(nums[j] + j > max){
                    max = nums[j] + j;
                    k = j;
                }
            }
            i = k;
        }
        return  isVisit[nums.length-1];
    }
}
