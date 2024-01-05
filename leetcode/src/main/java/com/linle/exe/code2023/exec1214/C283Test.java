package com.linle.exe.code2023.exec1214;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author chendeli
 * @Description: 移动零
 * @date 2022/12/14 16:01
 */
public class C283Test {

    /**
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     *
     * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
     * 提示:
     * 1 <= nums.length <= 104
     * -231 <= nums[i] <= 231 - 1
     *
     * 进阶：你能尽量减少完成的操作次数吗？
     */
    @Test
    public void test283() {
        int[] nums = {1,3,0,9,7,0,987};

        int size = 0;
        for(int i = 0; i<nums.length;i++){
            if(nums[i] == 0){
                size++;
                continue;
            }
            if(size != 0){
                nums[i-size] = nums[i];
            }
        }
        while(size > 0){
            nums[nums.length-size] = 0;
            size--;
        }

        Arrays.stream(nums).forEach(System.out::println);
    }
}
