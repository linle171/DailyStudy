package com.linle.exe.code2024.exec2401.exec240112;

import org.junit.Test;

import java.util.Arrays;

/**
 * @description: 1. 两数之和 simple
 * @author: chendeli
 * @date: 2024-01-12 23:20
 */
public class TwoSum {
    /**
     * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
     *
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
     *
     * 你可以按任意顺序返回答案。
     *
     *
     *
     * 示例 1：
     *
     * 输入：nums = [2,7,11,15], target = 9
     * 输出：[0,1]
     * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
     * 示例 2：
     *
     * 输入：nums = [3,2,4], target = 6
     * 输出：[1,2]
     * 示例 3：
     *
     * 输入：nums = [3,3], target = 6
     * 输出：[0,1]
     *
     *
     * 提示：
     *
     * 2 <= nums.length <= 104
     * -109 <= nums[i] <= 109
     * -109 <= target <= 109
     * 只会存在一个有效答案
     *
     *
     * 进阶：你可以想出一个时间复杂度小于 O(n2) 的算法吗？
     */
    @Test
    public void test(){
        int[] i = new int[]{2,5,5,7};
        twoSum(i,10);

    }


    /**
     * 解题思路：
     * 1、使用排序 然后二分查找 O(nlogn)
     * 2、使用map O(n)
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
            int[] arr = Arrays.copyOf(nums,nums.length);
            Arrays.sort(nums);
            for(int i = 0; i<nums.length;i++){
                int temp = target - nums[i];
                int j = banirySearch(nums,temp);
                if(j>0 && j!=i){
                    int[] finalResult = new int[2];
                    for(int k = 0; k< nums.length;k++){
                        if(finalResult[0] != 0 && arr[k] == nums[i]){
                            finalResult[0] = k;
                            continue;
                        }
                        if(arr[k] == nums[j]){
                            finalResult[1] = k;
                        }
                    }
                    return finalResult;
                }
            }
            return null;
        }

        private int banirySearch(int[] nums,int temp){
            int l = 0,r = nums.length-1;
            while(l<=r){
                int mid = l + ((r-l)>>1);
                if(nums[mid] == temp ){
                    if(mid<r && nums[mid+1] == temp){
                        return mid +1;
                    }
                    return mid;
                }else if(nums[mid] > temp){
                    r = mid -1;
                }else{
                    l = mid+1;
                }
            }
            return -1;
        }

}
