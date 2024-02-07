package com.linle.exe.code2024.exec2402.exec240203;

import org.checkerframework.checker.units.qual.A;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 763. 划分字母区间 middle
 * @author: chendeli
 * @date: 2024-02-03 20:36
 */
public class PartitionLabels {
    /**
     * 给你一个字符串 s 。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。
     *
     * 注意，划分结果需要满足：将所有划分结果按顺序连接，得到的字符串仍然是 s 。
     *
     * 返回一个表示每个字符串片段的长度的列表。
     *
     * 示例 1：
     * 输入：s = "ababcbacadefegdehijhklij"
     * 输出：[9,7,8]
     * 解释：
     * 划分结果为 "ababcbaca"、"defegde"、"hijhklij" 。
     * 每个字母最多出现在一个片段中。
     * 像 "ababcbacadefegde", "hijhklij" 这样的划分是错误的，因为划分的片段数较少。
     * 示例 2：
     *
     * 输入：s = "eccbbbbdec"
     * 输出：[10]
     *
     * 提示：
     *
     * 1 <= s.length <= 500
     * s 仅由小写英文字母组成
     */
    @Test
    public void test(){
        partitionLabels("ababcbacadefegdehijhklij");
    }

    /**
     *
     * 解题思路：
     * 1、
     * @param s
     * @return
     */
    public List<Integer> partitionLabels(String s) {
        int[] start = new int[26];
        int[] end = new int[26];
        Arrays.fill(start,-1);
        //统计每个字母的启示和结束位置
        for (int i = 0; i < s.toCharArray().length; i++) {
            char c = s.charAt(i);
            if(start[c-'a'] == -1){
                start[c-'a'] = i;
            }
            end[c-'a'] = i;
        }
        List<Integer> l = new ArrayList<>();
        //第二次遍历 获取结果
//        for (int i = 0; i < s.toCharArray().length; i++) {
//            char c = s.charAt(i);
//            int startV =  start[c-'a'];
//            int endV = end[c-'a'];
//            for (int j = startV+1; j < endV; j++) {
//                char n = s.charAt(j);
//                int endN = end[n - 'a'];
//                if(endN > endV){
//                    endV = endN;
//                }
//            }
//            i = endV;
//            l.add(endV-startV+1);
//        }
//        return l;


        //第二次遍历 获取结果
        for (int i = 0; i < s.toCharArray().length; i++) {
            int endV = end[s.charAt(i)-'a'];
            for (int j = i+1; j < endV; j++) {
                if(end[s.charAt(j) - 'a'] > endV){
                    endV = end[s.charAt(j) - 'a'];
                }
            }
            l.add(endV-i+1);
            i = endV;
        }
        return l;
    }
}
