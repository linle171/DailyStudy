package com.linle.exe.code2024.exec2402.exec240206;

import org.junit.Test;

/**
 * @description: 5. 最长回文子串 middle
 * @author: chendeli
 * @date: 2024-02-06 17:13
 */
public class LongestPalindrome {
    /**
     * 给你一个字符串 s，找到 s 中最长的回文子串。
     * <p>
     * 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
     * <p>
     * 示例 1：
     * <p>
     * 输入：s = "babad"
     * 输出："bab"
     * 解释："aba" 同样是符合题意的答案。
     * 示例 2：
     * <p>
     * 输入：s = "cbbd"
     * 输出："bb"
     * <p>
     * 提示：
     * <p>
     * 1 <= s.length <= 1000
     * s 仅由数字和英文字母组成
     */
    @Test
    public void test() {
        longestPalindrome("aacabdkacaa");
    }

    /**
     * 解题思路：
     * 1、
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {

        int len = s.length();
        char[] chars = s.toCharArray();
        boolean[][] isVisit = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp(isVisit,  i, chars);
        }
        return rel;
    }
    String rel = "";
    int max = 0;

    private void dp(boolean[][] isVisit, int c, char[] chars) {
        if (c > isVisit.length - 1) {
            return;
        }
        for (int i = 0; i <= c; i++) {
            isVisit[i][c] = chars[c] == chars[i] ? (i + 1 > c - 1 ? true : isVisit[i + 1][c - 1]) :false;
            if (isVisit[i][c]) {
                rel = c - i < max ? rel : String.copyValueOf(chars,i,c-i+1);
                max = Math.max(max, c-i);
            }
        }
    }
}
