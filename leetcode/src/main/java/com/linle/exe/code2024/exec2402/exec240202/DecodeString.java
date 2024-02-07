package com.linle.exe.code2024.exec2402.exec240202;

import org.junit.Test;

import java.util.Objects;
import java.util.Stack;

/**
 * @description: 394. 字符串解码 middle
 * @author: chendeli
 * @date: 2024-02-02 14:28
 */
public class DecodeString {
    /**
     * 给定一个经过编码的字符串，返回它解码后的字符串。
     *
     * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
     *
     * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
     *
     * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
     *
     * 示例 1：
     *
     * 输入：s = "3[a]2[bc]"
     * 输出："aaabcbc"
     * 示例 2：
     *
     * 输入：s = "3[a2[c]]"
     * 输出："accaccacc"
     * 示例 3：
     *
     * 输入：s = "2[abc]3[cd]ef"
     * 输出："abcabccdcdcdef"
     * 示例 4：
     *
     * 输入：s = "abc3[cd]xyz"
     * 输出："abccdcdcdxyz"
     *
     * 提示：
     *
     * 1 <= s.length <= 30
     * s 由小写英文字母、数字和方括号 '[]' 组成
     * s 保证是一个 有效 的输入。
     * s 中所有整数的取值范围为 [1, 300]
     */
    @Test
    public void test(){
        decodeString("3[a]2[bc]");
    }

    /**
     *
     * 解题思路：
     * 1、
     * @param s
     * @return
     */
    public String decodeString(String s) {
        Stack<String> sk = new Stack<>();
        StringBuffer sb = new StringBuffer();
        StringBuilder countL = new StringBuilder();
        for (int i = s.length()-1; i >= 0; i--) {
            if(Character.isDigit(s.charAt(i))){
                countL.insert(0, (s.charAt(i) - '0'));
                if(i == 0 || !Character.isDigit(s.charAt(i-1))){
                    dealSk(sk, Integer.parseInt(countL.toString()),sb);
                    sk.push(sb.toString());
                    sb.delete(0,sb.length());
                    countL.delete(0,countL.length());
                }
            }else {
                sk.push(String.valueOf(s.charAt(i)));
            }
        }
        while (!sk.isEmpty()){
            sb.append(sk.pop());
        }
        return sb.toString();
    }

    private void dealSk(Stack<String> sk, int count,StringBuffer sb) {
        while (!sk.isEmpty()){
            String pop = sk.pop();
            if(Objects.equals(pop,"[")){
                continue;
            }
            if(Objects.equals(pop,"]")){
                String sub = sb.toString();
                for (int i = 0; i < count-1; i++) {
                    sb.append(sub);
                }
                return;
            }
            sb.append(pop);
        }
    }
}
