package com.linle.exe.code2024.exec2402.exec240216;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @description: 136. 只出现一次的数字 simple
 * @author: chendeli
 * @date: 2024-02-16 17:53
 */
public class SingleNumber {
    /**
     * 给你一个 非空 整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
     *
     * 你必须设计并实现线性时间复杂度的算法来解决此问题，且该算法只使用常量额外空间。
     *
     *
     *
     * 示例 1 ：
     *
     * 输入：nums = [2,2,1]
     * 输出：1
     * 示例 2 ：
     *
     * 输入：nums = [4,1,2,1,2]
     * 输出：4
     * 示例 3 ：
     *
     * 输入：nums = [1]
     * 输出：1
     *
     *
     * 提示：
     *
     * 1 <= nums.length <= 3 * 104
     * -3 * 104 <= nums[i] <= 3 * 104
     * 除了某个元素只出现一次以外，其余每个元素均出现两次。
     */
    @Test
    public void test(){
        singleNumber(new int[]{2,1,2,1,4});
    }

    public int singleNumber(int[] nums) {
        int target = nums[0];
        for (int i = 1; i < nums.length; i++) {
            target ^= nums[i];
        }



        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if(set.contains(nums[i])){
                set.remove(nums[i]);
            }else {
                set.add(nums[i]);
            }
        }
        return set.stream().findFirst().get();
    }

}
