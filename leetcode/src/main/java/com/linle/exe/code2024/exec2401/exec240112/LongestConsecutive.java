package com.linle.exe.code2024.exec2401.exec240112;

import org.apache.tomcat.util.security.Escape;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * @description: 128. 最长连续序列 middle
 * @author: chendeli
 * @date: 2024-01-13 13:00
 */
public class LongestConsecutive {
    /**
     * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
     *
     * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
     *
     * 示例 1：
     *
     * 输入：nums = [100,4,200,1,3,2]
     * 输出：4
     * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
     * 示例 2：
     *
     * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
     * 输出：9
     *
     * 提示：
     *
     * 0 <= nums.length <= 10^5
     * -10^9 <= nums[i] <= 10^9
     */

    @Test
    public void test(){
        int[] strs = {0,3,7,2,5,8,4,6,0,1};
        longestConsecutive(strs);
    }

    /**
     * 解题思路：
     *
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int num : nums) {
            treeSet.add(num);
        }
        int max = 0;
        int count = 1;
        Integer pre = null;
        for (Integer i : treeSet) {
            if( pre == null){
                pre = i;
                continue;
            }
            if(i == pre + 1){
                count++;
            }else {
                max  = Math.max(max,count);
                count = 1;
            }
            pre = i;
        }
        return Math.max(max,count);
    }

    public int longestConsecutive1(int[] nums) {
        Set<Integer> treeSet = new HashSet<>();
        for (int num : nums) {
            treeSet.add(num);
        }
        int max = 0;
        int count = 1;
        Integer pre = null;
        for (Integer i : treeSet) {
            if( pre == null){
                pre = i;
                continue;
            }
            if(i == pre + 1){
                count++;
            }else {
                max  = Math.max(max,count);
                count = 1;
            }
            pre = i;
        }
        return Math.max(max,count);
    }
}
