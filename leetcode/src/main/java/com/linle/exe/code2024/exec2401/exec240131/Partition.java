package com.linle.exe.code2024.exec2401.exec240131;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 131. 分割回文串 middle
 * @author: chendeli
 * @date: 2024-01-31 18:23
 */
public class Partition {
    /**
     * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
     *
     * 回文串 是正着读和反着读都一样的字符串。
     *
     * 示例 1：
     *
     * 输入：s = "aab"
     * 输出：[["a","a","b"],["aa","b"]]
     * 示例 2：
     *
     * 输入：s = "a"
     * 输出：[["a"]]
     *
     * 提示：
     *
     * 1 <= s.length <= 16
     * s 仅由小写英文字母组成
     */
    @Test
    public void test(){
        partition("aab");
    }

    /**
     *
     * 解题思路：
     * 1、
     * @param s
     * @return
     */
    List<List<String>> list = new ArrayList<>();
    public List<List<String>> partition(String s) {
        //先判断每个组合是否为回文
        boolean[][] isPalindromic = new boolean[s.length()][s.length()];
        for (int i = 0; i <s.length(); i++) {
            record(isPalindromic,0,i,s);
        }
        //取数据
        execute(isPalindromic,0,0,new ArrayList(),s);
        return list;
    }


    private void execute(boolean[][] isPalindromic, int i, int j, List<String> ls, String s) {
        if(j == isPalindromic.length){
            list.add(new ArrayList<>(ls));
        }
        for (int k = j; k < isPalindromic.length; k++) {
                if(isPalindromic[i][k]){
                    ls.add(s.substring(i,k+1));
                    execute(isPalindromic,k+1,k+1,ls, s);
                    ls.remove(ls.size()-1);
                }
        }
    }

    private void record(boolean[][] isPalindromic, int l, int r,String s) {
        if(r > s.length() -1){
            return;
        }
        if(s.charAt(l) == s.charAt(r)){
            isPalindromic[l][r] = true;
            if( l+1 <= r-1){
                isPalindromic[l][r] = isPalindromic[l+1][r-1];
            }
        }else {
            isPalindromic[l][r] = false;
        }
        record(isPalindromic,l+1,r+1,s);
    }
}
