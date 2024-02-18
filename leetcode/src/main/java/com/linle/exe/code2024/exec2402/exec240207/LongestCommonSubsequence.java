package com.linle.exe.code2024.exec2402.exec240207;

import org.junit.Test;

import java.util.*;

/**
 * @description: 1143. 最长公共子序列 middle
 * @author: chendeli
 * @date: 2024-02-07 09:25
 */
public class LongestCommonSubsequence {
    /**
     * 给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
     *
     * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
     *
     * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
     * 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
     *
     * 示例 1：
     *
     * 输入：text1 = "abcde", text2 = "ace"
     * 输出：3
     * 解释：最长公共子序列是 "ace" ，它的长度为 3 。
     * 示例 2：
     *
     * 输入：text1 = "abc", text2 = "abc"
     * 输出：3
     * 解释：最长公共子序列是 "abc" ，它的长度为 3 。
     * 示例 3：
     *
     * 输入：text1 = "abc", text2 = "def"
     * 输出：0
     * 解释：两个字符串没有公共子序列，返回 0 。
     *
     * 提示：
     *
     * 1 <= text1.length, text2.length <= 1000
     * text1 和 text2 仅由小写英文字符组成。
     */
    @Test
    public void test(){
        longestCommonSubsequence1("abcbcba","abcba");
    }


    public int longestCommonSubsequence(String text1, String text2) {
        String l1 = text1.length() > text2.length() ? text1 : text2;
        String l2 = text1.length() > text2.length() ? text2 : text1;
        //标记l2每个字符对于l1中的位置
        int[] isVisit = new int[l2.length()];
        //标记已经比对过的字符及其字数
        int[] remark = new int[26];
        //记录各个字符在字符串中出现的位置
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < l1.length(); i++) {
            List<Integer> l = map.getOrDefault(l1.charAt(i), new ArrayList<>());
            l.add(i);
            map.put(l1.charAt(i),l);
        }
        Arrays.fill(isVisit,-1);
        for (int i = 0; i < l2.length(); i++) {
            char c = l2.charAt(i);
            int count = remark[c-'a'];
            if(map.containsKey(c)){
                List<Integer> l = map.get(c);
                Integer index = l.get(count);
                isVisit[i] = index;
                remark[c-'a']++;
            }
        }
        //问题转变为最长递增列表
        for (int i = 0; i < isVisit.length; i++) {

        }



        return 0;
    }


    public int longestCommonSubsequence1(String text1, String text2) {
        String l1 = text1.length() > text2.length() ? text1 : text2;
        String l2 = text1.length() > text2.length() ? text2 : text1;
        int len1 = l1.length();
        int len2 = l2.length();
        int[][] count = new int[len2+1][len1+1];
        for (int i = 1; i < len2+1; i++) {
            for (int j = 1; j < len1+1; j++) {
                if(l2.charAt(i-1) == l1.charAt(j-1) ){
                    count[i][j] = count[i-1][j-1]+1;
                }else {
                    count[i][j] = Math.max(count[i][j-1],count[i-1][j]);
                }
            }
        }
        return  count[len2][len1];

    }
}
