package com.linle.exe.code2023.exec1215;

import org.junit.Test;

/**
 * @author chendeli
 * @Description: . 反转字符串中的单词 III
 * @date 2022/12/15 10:11
 */
public class C577Test {
    /**
     * 给定一个字符串 s ，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
     * <p>
     * 提示：
     * <p>
     * 1 <= s.length <= 5 * 104
     * s 包含可打印的 ASCII 字符。
     * s 不包含任何开头或结尾空格。
     * s 里 至少 有一个词。
     * s 中的所有单词都用一个空格隔开。
     */
    @Test
    public void test577() {
        String s = "god bless you";
        char[] chars = s.toCharArray();
        int pre = -1, sub = -1;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                pre = sub;
                sub = i;
                reverse(pre + 1, sub - 1, chars);
            }
            if (i == chars.length - 1 && sub != -1) {
                reverse(sub + 1, i, chars);
            }
        }
        System.out.println(String.valueOf(chars));
    }

    private void reverse(int pre, int sub, char[] chars) {
        while (pre < sub) {
            swap(pre, sub, chars);
            pre++;
            sub--;
        }
    }

    private void swap(int left, int right, char[] s) {
        char temp = s[left];
        s[left] = s[right];
        s[right] = temp;
    }
}
