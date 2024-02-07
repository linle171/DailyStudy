package com.linle.exe.code2024.exec240106;

import org.junit.Test;

import java.util.Stack;

/**
 * @description: 32. 最长有效括号 difficult
 * @author: chendeli
 * @date: 2024-01-06 12:32
 */
public class  LongestValidParentheses {
    /**
     * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
     * <p>
     * 示例 1：
     * <p>
     * 输入：s = "(()"
     * 输出：2
     * 解释：最长有效括号子串是 "()"
     * 示例 2：
     * <p>
     * 输入：s = ")()())"
     * 输出：4
     * 解释：最长有效括号子串是 "()()"
     * 示例 3：
     * <p>
     * 输入：s = ""
     * 输出：0
     * <p>
     * 提示：
     * <p>
     * 0 <= s.length <= 3 * 104
     * s[i] 为 '(' 或 ')'
     */
    @Test
    public void test() {
        String s =
                "(()";
        longestValidParentheses(s);
    }

    /**
     * 1、存在子集
     * 2、不存在子集计算
     *
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        int len = s.length();
        int[] visitor = new int[len];
        Stack<Integer> sk = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '('){
                sk.push(i);
                visitor[i] = 1;
            }
            if(c == ')'){
                if(!sk.isEmpty()){
                    Integer index = sk.pop();
                    visitor[index] = 3;
                    visitor[i] = 3;
                }else visitor[i] = 2;
            }
        }
        int max =0;
        int count = 0;
        for (int i = 0; i < visitor.length; i++) {
            if(visitor[i] == 3){
                count++;
            }else {
                max = Math.max(max,count);
                count = 0;
            }
        }
        return max = Math.max(max,count);
    }


    public int longestValidParentheses1(String s) {
        char[] str = s.toCharArray();
        int n = str.length, max = 0;
        int[] dp = new int[n];
        for (int i = 1; i < n; i++) {
            if (str[i] != '(' && i - dp[i - 1] - 1 >= 0 && str[i - dp[i - 1] - 1] == '(') {
                dp[i] = dp[i - 1] + 2;
                if (i - dp[i - 1] - 2 >= 0) {
                    dp[i] += dp[i - dp[i - 1] - 2];
                }
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }


    public int longestValidParentheses2(String s) {
        int maxans = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxans = Math.max(maxans, dp[i]);
            }
        }
        return maxans;
    }


}
