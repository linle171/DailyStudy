package com.linle.exe.code2024.exec240107;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description: 151. 反转字符串中的单词 middle
 * @author: chendeli
 * @date: 2024-01-07 23:45
 */
public class ReverseWords {
    /**
     * 给你一个字符串 s ，请你反转字符串中 单词 的顺序。
     *
     * 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
     *
     * 返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
     *
     * 注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。
     *
     * 示例 1：
     *
     * 输入：s = "the sky is blue"
     * 输出："blue is sky the"
     * 示例 2：
     *
     * 输入：s = "  hello world  "
     * 输出："world hello"
     * 解释：反转后的字符串中不能存在前导空格和尾随空格。
     * 示例 3：
     *
     * 输入：s = "a good   example"
     * 输出："example good a"
     * 解释：如果两个单词间有多余的空格，反转后的字符串需要将单词间的空格减少到仅有一个。
     *
     * 提示：
     *
     * 1 <= s.length <= 104
     * s 包含英文大小写字母、数字和空格 ' '
     * s 中 至少存在一个 单词
     *
     * 进阶：如果字符串在你使用的编程语言中是一种可变数据类型，请尝试使用 O(1) 额外空间复杂度的 原地 解法。
     */
    @Test
    public void test() {
        String s = "  s a    b   ";
        String s1 = reverseWords(s);
        System.out.println(s1);
    }

    /**
     * 解题思路：排除多余的空格
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        String[] split = s.split(" ");
        List<String> ls = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            if(split[i] != ""){
                ls.add(split[i]);
            }
        }
        String[] array = ls.toArray(new String[]{});
        int l = 0;
        int r = array.length-1;
        String temp;
        while(l < r){
            temp = array[l];
            array[l] = array[r];
            array[r] = temp;
            l++;
            r--;
        }
        return Arrays.stream(array).collect(Collectors.joining(" "));
    }

    public String reverseWords1(String s) {
        int l = 0,r = s.length()-1;
        while(l <= r && s.charAt(l) == ' '){
            l++;
        }
        while(l <= r && s.charAt(r) == ' '){
            r++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = l; i <= r; i++) {

        }
        return null;
    }
}
