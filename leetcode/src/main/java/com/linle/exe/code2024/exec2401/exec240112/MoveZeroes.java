package com.linle.exe.code2024.exec2401.exec240112;

import org.junit.Test;
import org.springframework.web.servlet.FlashMap;

/**
 * @description: 283. 移动零 simple
 * @author: chendeli
 * @date: 2024-01-13 16:50
 */
public class MoveZeroes {
    /**
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     * <p>
     * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
     * <p>
     * 示例 1:
     * <p>
     * 输入: nums = [0,1,0,3,12]
     * 输出: [1,3,12,0,0]
     * 示例 2:
     * <p>
     * 输入: nums = [0]
     * 输出: [0]
     * <p>
     * 提示:
     * <p>
     * 1 <= nums.length <= 104
     * -23^1 <= nums[i] <= 23^1 - 1
     * <p>
     * 进阶：你能尽量减少完成的操作次数吗？
     */
    @Test
    public void test() {
        int[] i = new int[]{0, 1, 0, 3, 12};
        moveZeroes(i);
    }

    /**
     * 解题思路：前后指针 后指针定位不等于0的index 前指针定位等于0的 进行值交换
     *
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        for (int i = 0, pre = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if(i!=pre) {
                    nums[i] = nums[i] ^ nums[pre];
                    nums[pre] = nums[i] ^ nums[pre];
                    nums[i] = nums[pre] ^ nums[i];
                }
                pre++;
            }
        }
        System.out.println(nums);
    }

    /**
     * 解题思路：前后指针 后指针定位不等于0的index 前指针定位等于0的 直接赋值，减少了交换值的操作
     *
     * @param nums
     */
    public void moveZeroes1(int[] nums) {
        int pre = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if(i!=pre) {
                    nums[pre] = nums[i];
                }
                pre++;
            }
        }
        while(pre < nums.length){
            nums[pre++] = 0;
        }
    }
}
