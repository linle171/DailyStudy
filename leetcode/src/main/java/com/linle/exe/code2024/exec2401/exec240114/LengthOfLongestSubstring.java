package com.linle.exe.code2024.exec2401.exec240114;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 3. 无重复字符的最长子串 middle
 * @author: chendeli
 * @date: 2024-01-14 17:43
 */
public class LengthOfLongestSubstring {
    /**
     * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
     *
     * 示例 1:
     *
     * 输入: s = "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     * 示例 2:
     *
     * 输入: s = "bbbbb"
     * 输出: 1
     * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     * 示例 3:
     *
     * 输入: s = "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     *
     * 提示：
     *
     * 0 <= s.length <= 5 * 104
     * s 由英文字母、数字、符号和空格组成
     */
    @Test
    public void test(){
        String s = "abcabcbb";
        lengthOfLongestSubstring(s);
    }

    /**
     * 解题思路：
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int maxLen = 0;
        int i = 0,pre = 0;
        for (; i < s.length(); i++) {
            char c = s.charAt(i);
            if(map.containsKey(c)){
                int temp = map.get(c);
                if(pre <= temp) {
                    maxLen = Math.max(i - pre, maxLen);
                    pre = map.get(c) + 1;
                }
            }
            map.put(c,i);
        }
        return Math.max(maxLen,i-pre) ;
    }
}
