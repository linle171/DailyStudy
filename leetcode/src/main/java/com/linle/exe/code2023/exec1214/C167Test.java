package com.linle.exe.code2023.exec1214;

import org.junit.Test;

/**
 * @author chendeli
 * @Description: 两数之和 II - 输入有序数组
 * @date 2022/12/14 16:51
 */
public class C167Test {
    /**
     * 给你一个下标从 1 开始的整数数组 numbers ，该数组已按 非递减顺序排列  ，
     * 请你从数组中找出满足相加之和等于目标数 target 的两个数。如果设这两个数分别是 numbers[index1] 和 numbers[index2] ，
     * 则 1 <= index1 < index2 <= numbers.length 。
     *
     * 以长度为 2 的整数数组 [index1, index2] 的形式返回这两个整数的下标 index1 和 index2。
     *
     * 你可以假设每个输入 只对应唯一的答案 ，而且你 不可以 重复使用相同的元素。
     *
     * 你所设计的解决方案必须只使用常量级的额外空间。
     *
     *
     * 2 <= numbers.length <= 3 * 104
     * -1000 <= numbers[i] <= 1000
     * numbers 按 非递减顺序 排列
     * -1000 <= target <= 1000
     * 仅存在一个有效答案
     */


    @Test
    public void test167(){
        int[] numbers = {1,2,3,4,5,6,10};
        int target = 12;
        for(int i=0,j = numbers.length -1;i<j;){
            int sum = numbers[i] +numbers[j];
            if(sum == target){
//                return new int[]{i+1,j+1};
                return ;
            }
            else if( sum > target){
                i++;
            }else {
                j--;
            }
        }

    }
}
