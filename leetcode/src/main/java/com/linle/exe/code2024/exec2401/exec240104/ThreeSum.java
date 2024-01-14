package com.linle.exe.code2024.exec2401.exec240104;

import org.junit.Test;

import java.util.*;

/**
 * @description: 15题 . 三数之和
 * @author: chendeli
 * @date: 2024-01-04 10:12
 */
public class ThreeSum {

    /**
     * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
     * <p>
     * 你返回所有和为 0 且不重复的三元组。
     * <p>
     * 注意：答案中不可以包含重复的三元组。
     */
    @Test
    public void test() {

        int[] ints = {1, 2, 5, 3};

        threeSum(ints);
    }

    /**
     * 解决方法： 先排序，然后双指针
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
//        quickSort(0, nums.length-1, nums);
        Set<List<Integer>> l = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int k = nums.length - 1;
            for (int j = i + 1; j < nums.length ; j++) {
                 int temp = nums[i] + nums[j];
                 while(k > j && temp + nums[k] > 0){
                     k--;
                 }
                 if( k > j && temp + nums[k] == 0){
                     List<Integer> a = new ArrayList<>();
                     a.add(nums[i]);
                     a.add(nums[j]);
                     a.add(nums[k]);
                     a.sort((o1, o2) -> {
                         if (o1 >o2){
                             return 1;
                         }
                         return -1;
                     } );
                     l.add(a);
                 }
            }
        }
        return l.stream().toList();
    }

    private void quickSort(int l, int r, int[] nums) {
        if (l >= r) {
            return;
        }
        int q = partition(nums, l, r);
        quickSort(l, q - 1, nums);
        quickSort(q + 1, r, nums);
    }

    private int partition(int[] nums, int l, int r) {
        int temp = r;
        while (l < r) {
            while (l < r && nums[l] <= nums[temp]) {
                l++;
            }
            while (l < r && nums[r] >= nums[temp]) {
                r--;
            }
            if (l < r) {
                swap(nums, l, r);
                r--;
                l++;
            }
        }
        swap(nums, temp, r );
        return l;
    }

    private void swap(int[] nums, int l, int r) {
        if(l == r){
            return;
        }
        nums[l] = nums[l] ^ nums[r];
        nums[r] = nums[l] ^ nums[r];
        nums[l] = nums[l] ^ nums[r];
    }
}
