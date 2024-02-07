package com.linle.exe.code2024.exec2401.exec240130;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 46. 全排列 middle
 * @author: chendeli
 * @date: 2024-01-30 13:39
 */
public class Permute {
    /**
     * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
     *
     * 示例 1：
     *
     * 输入：nums = [1,2,3]
     * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
     * 示例 2：
     *
     * 输入：nums = [0,1]
     * 输出：[[0,1],[1,0]]
     * 示例 3：
     *
     * 输入：nums = [1]
     * 输出：[[1]]
     *
     * 提示：
     *
     * 1 <= nums.length <= 6
     * -10 <= nums[i] <= 10
     * nums 中的所有整数 互不相同
     */
    @Test
    public void test(){
        permute(new int[]{1,2,3});
    }

    /**
     *
     * 解题思路：
     * 1、
     * @param nums
     * @return
     */
    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> l = new ArrayList<>();
        Arrays.stream(nums).forEach(l::add);
        sort(l,new ArrayList<Integer>());
        return list;
    }

    private void sort(List<Integer> source, List<Integer> temp) {
        if(source.isEmpty()){
            list.add(temp);
            return;
        }
        for (int i = 0; i < source.size(); i++) {
            List<Integer> l = new ArrayList<>();
            l.addAll(temp);
            l.add(source.get(i));

            List<Integer> next = new ArrayList<>(source);
            next.remove(i);
            sort(next,l);
        }
    }

/**********************************************************/
    List<List<Integer>> list1 = new ArrayList<>();
    public List<List<Integer>> permute1(int[] nums) {
        helper(nums, 0);
        return list;
    }

    private void helper(int[] nums, int index) {
        if (index == nums.length) {
            List<Integer> l = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                l.add(nums[i]);
            }
            list.add(l);
            return;
        }

        for (int i = index; i < nums.length; i++) {
            swap(nums, i, index);
            helper(nums, index + 1);
            swap(nums, i, index);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
