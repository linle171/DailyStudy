package com.linle.exe.code2024.exec2401.exec240130;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 78. 子集 middle
 * @author: chendeli
 * @date: 2024-01-30 14:52
 */
public class Subsets {
    /**
     * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
     *
     * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
     *
     * 示例 1：
     *
     * 输入：nums = [1,2,3]
     * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
     * 示例 2：
     *
     * 输入：nums = [0]
     * 输出：[[],[0]]
     *
     * 提示：
     *
     * 1 <= nums.length <= 10
     * -10 <= nums[i] <= 10
     * nums 中的所有元素 互不相同
     */
    @Test
    public void test(){
        subsets1(new int[]{1,2,3});
    }

    /**
     *
     * 解题思路：
     * 1、
     * @param nums
     * @return
     */
    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> l = new ArrayList<>();
        Arrays.stream(nums).forEach(l::add);
        for (int i = 0; i <= nums.length; i++) {
            sub(nums,i,0,0,new ArrayList<Integer>());
        }
        return list;
    }

    private void sub(int[] nums, int len, int index, int step, List<Integer> pre) {
        if(len == index){
            list.add(pre);
            return;
        }
        for (int i = step; i <nums.length; i++) {
            if(pre.contains(nums[i])){
                continue;
            }
            List<Integer> l = new ArrayList<>();
            l.addAll(pre);
            l.add(nums[i]);

            sub(nums, len,index+1,i+1, l);
        }

    }
    /***************************************************************/
    List<List<Integer>> res;
    List<Integer> path;
    public List<List<Integer>> subsets1(int[] nums) {
        res = new ArrayList<List<Integer>>();
        path = new ArrayList<Integer>();

        getRes(nums,0);
        return res;
    }
    public void getRes(int[] nums,int index){
        if(index>=nums.length){
            res.add(new ArrayList<>(path));
            return ;
        }
        path.add(nums[index]);
        getRes(nums,index+1);
        path.remove(path.size()-1);
        getRes(nums,index+1);
    }
}
