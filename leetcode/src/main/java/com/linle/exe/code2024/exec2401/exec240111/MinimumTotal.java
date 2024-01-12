package com.linle.exe.code2024.exec2401.exec240111;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 120. 三角形最小路径和 middle
 * @author: chendeli
 * @date: 2024-01-11 22:37
 */
public class MinimumTotal {

    /**
     * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
     *
     * 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
     *
     * 示例 1：
     *
     * 输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
     * 输出：11
     * 解释：如下面简图所示：
     *    2
     *   3 4
     *  6 5 7
     * 4 1 8 3
     * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
     * 示例 2：
     *
     * 输入：triangle = [[-10]]
     * 输出：-10
     *
     * 提示：
     *
     * 1 <= triangle.length <= 200
     * triangle[0].length == 1
     * triangle[i].length == triangle[i - 1].length + 1
     * -104 <= triangle[i][j] <= 104
     */
    @Test
    public void test(){
        int[][] i = new int[][]{{2},{3,4},{6,5,7},{4,1,8,3}};
        List<List<Integer>> l =   new ArrayList<>();
        ArrayList<Integer> i1 = Lists.newArrayList(2);
        ArrayList<Integer> i2 = Lists.newArrayList(3,4);
        ArrayList<Integer> i3 = Lists.newArrayList(6,5,7);
        ArrayList<Integer> i4 = Lists.newArrayList(4,1,8,3);
        l.add(i1);
        l.add(i2);
        l.add(i3);
        l.add(i4);
        int i5 = minimumTotal(l);
        System.out.println(i5);

    }

    /**
     * 解题思路：
     *
     * @param triangle  f(i)(n) = min(f(i-1)(n-1),f(i-1)(n));
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] list = new int[triangle.get(triangle.size()-1).size()];
        for (int i = 0; i < triangle.size(); i++) {
            List<Integer> temp = triangle.get(i);
            for (int j = temp.size()-1; j >0; j--) {
                if(j == temp.size() -1){
                    list[j] = list[j-1] + temp.get(j);
                }else {
                    list[j] = Math.min(list[j-1],list[j]) + temp.get(j);
                }
            }
            list[0] = list[0] + temp.get(0);
        }
        return Arrays.stream(list).min().getAsInt();
    }

}
