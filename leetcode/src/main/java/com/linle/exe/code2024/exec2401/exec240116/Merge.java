package com.linle.exe.code2024.exec2401.exec240116;

import org.checkerframework.checker.units.qual.A;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @description: 56. 合并区间 middle
 * @author: chendeli
 * @date: 2024-01-16 14:28
 */
public class Merge {

    /**
     * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
     *
     * 示例 1：
     *
     * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
     * 输出：[[1,6],[8,10],[15,18]]
     * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
     * 示例 2：
     *
     * 输入：intervals = [[1,4],[4,5]]
     * 输出：[[1,5]]
     * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
     *
     * 提示：
     *
     * 1 <= intervals.length <= 10^4
     * intervals[i].length == 2
     * 0 <= starti <= endi <= 10^4
     */
    @Test
    public void  test(){
        merge(new int[][]{{1,3},{2,6},{8,10},{15,18}});
    }


    /**
     * 解题思路：先根据第一个数进行排序 然后遍历数组    （i,j） (i,k)  j>i&&j<k r=k ; j<i终止区间 ；j>继续
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        List<int[]> list = new ArrayList<>();
        int p = intervals[0][0],s=intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            int[] suf = intervals[i];
            if(s < suf[0] ){
                list.add(new int[]{p,s});
                p = suf[0];
                s = suf[1];
            }
            s = Math.max(s,suf[1]);
        }
        list.add(new int[]{p,s});
        return list.toArray(new int[][]{});
    }

    /**
     * 解题思路：先根据第一个数进行排序 然后遍历数组    （i,j） (i,k)  j>i&&j<k r=k ; j<i终止区间 ；j>继续
     * @param intervals
     * @return
     */
    public int[][] merge1(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        List<int[]> list = new ArrayList<>();
        int p = intervals[0][0],s=intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            int[] suf = intervals[i];
            if(s < suf[0] ){
                list.add(new int[]{p,s});
                p = suf[0];
                s = suf[1];
            }
            s = Math.max(s,suf[1]);
        }
        list.add(new int[]{p,s});
        return list.toArray(new int[][]{});
    }


    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        while(m > 0 && n > 0){
            if(nums1[m-1] > nums2[n-1]){
                nums1[m+n-1] = nums1[m-1];
                m--;
            }else{
                nums1[m+n-1] = nums2[n-1];
                n--;
            }
        }
    }

}
