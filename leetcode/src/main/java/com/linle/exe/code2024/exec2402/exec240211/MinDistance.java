package com.linle.exe.code2024.exec2402.exec240211;

import com.linle.exe.code2024.exec2401.exec240112.MaxArea;
import org.junit.Test;

/**
 * @description: 72. 编辑距离 middle
 * @author: chendeli
 * @date: 2024-02-11 22:45
 */
public class MinDistance {
    /**
     * 给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数  。
     * 你可以对一个单词进行如下三种操作：
     * 插入一个字符
     * 删除一个字符
     * 替换一个字符
     * 示例 1：
     * 输入：word1 = "horse", word2 = "ros"
     * 输出：3
     * 解释：
     * horse -> rorse (将 'h' 替换为 'r')
     * rorse -> rose (删除 'r')
     * rose -> ros (删除 'e')
     * 示例 2：
     * 输入：word1 = "intention", word2 = "execution"
     * 输出：5
     * 解释：
     * intention -> inention (删除 't')
     * inention -> enention (将 'i' 替换为 'e')
     * enention -> exention (将 'n' 替换为 'x')
     * exention -> exection (将 'n' 替换为 'c')
     * exection -> execution (插入 'u')
     * <p>
     * 提示：
     * <p>
     * 0 <= word1.length, word2.length <= 500
     * word1 和 word2 由小写英文字母组成
     */
    @Test
    public void test() {
        minDistance("intention","execution");
    }

    /**
     * dp
     * 1、问题转换为 A插入 B插入 修改三个操作
     * 2、dp[i][j] = Math.min(dp[i-1][j]+1,dp[i][j-1]+1,dp[i-1][j-1])
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        if(len2*len1 == 0){
            return len1+len2;
        }

        int[][] dp = new int[len1][len2];
        for (int i = 0; i < len1; i++) {
            dp[0][i] = i;
        }
        for (int i = 0; i < len2; i++) {
            dp[i][0] = i;
        }

        for (int i = 1; i < len1; i++) {
            for (int j = 1; j < len2; j++) {
                int l = dp[i][j-1] +1;
                int r = dp[i-1][j]+1;
                int left_down = dp[i-1][j-1];
                if(word1.charAt(i-1) != word2.charAt(j-1)){
                    left_down++;
                }
                dp[i][j] = Math.min(Math.min(l,r),left_down);
            }
        }


        return dp[len1][len2];
    }

}

