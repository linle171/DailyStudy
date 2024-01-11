package com.linle.exe.code2024.exec2401.exec240110;

import org.junit.Test;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.temporal.IsoFields;

/**
 * @description: 10. 正则表达式匹配 difficult
 *
 * @author: chendeli
 * @date: 2024-01-10 09:35
 */
//TODO 可以重新写过
public class IsMatch {

    /**
     * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
     * <p>
     * '.' 匹配任意单个字符
     * '*' 匹配零个或多个前面的那一个元素
     * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
     * <p>
     * 示例 1：
     * <p>
     * 输入：s = "aa", p = "a"
     * 输出：false
     * 解释："a" 无法匹配 "aa" 整个字符串。
     * 示例 2:
     * <p>
     * 输入：s = "aa", p = "a*"
     * 输出：true
     * 解释：因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
     * 示例 3：
     * <p>
     * 输入：s = "ab", p = ".*"
     * 输出：true
     * 解释：".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
     * <p>
     * 提示：
     * <p>
     * 1 <= s.length <= 20
     * 1 <= p.length <= 20
     * s 只包含从 a-z 的小写字母。
     * p 只包含从 a-z 的小写字母，以及字符 . 和 *。
     * 保证每次出现字符 * 时，前面都匹配到有效的字符
     */
    @Test
    public void test() {
        String s = "a";
        String p = "ac*b*d*";
        boolean match = isMatch1(s, p);
        System.out.println(match);
    }

    /**
     * 解体思路: 难点在于 *，如何计算*是匹配多少个字符
     *
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        return getMatch(s, p, 0, 0);
    }

    private boolean getMatch(String s, String p, int l, int r) {
        if (s.length() == l || p.length() == r) {
            while(r+1<p.length() && p.charAt(r+1) == '*'){
                r += 2;
            }
            return  !(p.length() != r || s.length() != l);
        }

        if (p.charAt(r) == '.' || p.charAt(r) == s.charAt(l) ) {
            boolean a = false;
            boolean b = false;
            if(r < p.length() -1 && p.charAt(r+1) == '*'){
                a = getMatch(s, p, l , r + 2) ;
                b = getMatch(s, p, l+1 , r);
                return a||b;
            }
            return getMatch(s, p, l + 1, r + 1);
        } else if(r < p.length() -1 && p.charAt(r+1) == '*'){
            return getMatch(s,p,l,r+2);
        }
        return false;
    }

    public boolean isMatch1(String s, String p) {
        int m = s.length();
        int n = p.length();

        boolean[][] f = new boolean[m + 1][n + 1];
        f[0][0] = true;
        for (int i = 0; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (p.charAt(j - 1) == '*') {
                    f[i][j] = f[i][j - 2];
                    if (matches(s, p, i, j - 1)) {
                        f[i][j] = f[i][j] || f[i - 1][j];
                    }
                } else {
                    if (matches(s, p, i, j)) {
                        f[i][j] = f[i - 1][j - 1];
                    }
                }
            }
        }
        return f[m][n];
    }

    public boolean matches(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }


}
