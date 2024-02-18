package com.linle.exe.code2024.exec2402.exec240217;

import org.junit.Test;

import java.util.Random;

/**
 * @description: 75. 颜色分类 middle
 * @author: chendeli
 * @date: 2024-02-17 10:20
 */
public class SortColors {
    /**
     * 给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地对它们进行排序，使得相同颜色的元素相邻，
     * 并按照红色、白色、蓝色顺序排列。
     * <p>
     * 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
     * <p>
     * 必须在不使用库内置的 sort 函数的情况下解决这个问题。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [2,0,2,1,1,0]
     * 输出：[0,0,1,1,2,2]
     * 示例 2：
     * <p>
     * 输入：nums = [2,0,1]
     * 输出：[0,1,2]
     * <p>
     * <p>
     * 提示：
     * <p>
     * n == nums.length
     * 1 <= n <= 300
     * nums[i] 为 0、1 或 2
     * <p>
     * <p>
     * 进阶：
     * <p>
     * 你能想出一个仅使用常数空间的一趟扫描算法吗？
     */
    @Test
    public void test() {
        Random random = new Random();
        int index = random.nextInt(0, 10);
        System.out.println(index);
    }

    /**
     * 解题思路
     * 1、使用快拍咯
     *
     * @param nums
     */
    public void sortColors(int[] nums) {
        int len = nums.length;
        quickSort(0,len-1,nums);
    }

    private void quickSort(int l, int r, int[] nums) {
        if(l > r){
            return;
        }
        Random random = new Random();
        int index = random.nextInt(0, r);
        int temp = nums[index];
        int lT = l;
        int rT = r;
        while(lT<=rT){
            if(nums[lT] >= temp && nums[rT] <= temp) {
                int t = nums[lT] ^ nums[rT];
                nums[rT] = t ^ nums[rT];
                nums[lT] = t ^ nums[lT];
                lT++;
                rT--;
                continue;
            }
            if(nums[lT] < temp){
                lT++;
            }
            if(nums[rT] > temp){
                rT--;
            }
        }
        quickSort(l,lT-1,nums);
        quickSort(lT+1,r,nums);
    }

}
