package com.linle.exe.code2024.exec2402.exec240204;

import org.junit.Test;

import java.util.*;

/**
 * @description: 139. 单词拆分 middle
 * @author: chendeli
 * @date: 2024-02-04 17:56
 */
public class WordBreak {
    /**
     * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。如果可以利用字典中出现的一个或多个单词拼接出 s 则返回 true。
     *
     * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
     *
     * 示例 1：
     *
     * 输入: s = "leetcode", wordDict = ["leet", "code"]
     * 输出: true
     * 解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。
     * 示例 2：
     *
     * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
     * 输出: true
     * 解释: 返回 true 因为 "applepenapple" 可以由 "apple" "pen" "apple" 拼接成。
     *      注意，你可以重复使用字典中的单词。
     * 示例 3：
     *
     * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
     * 输出: false
     *
     * 提示：
     *
     * 1 <= s.length <= 300
     * 1 <= wordDict.length <= 1000
     * 1 <= wordDict[i].length <= 20
     * s 和 wordDict[i] 仅由小写英文字母组成
     * wordDict 中的所有字符串 互不相同
     */
    @Test
    public void test(){
        wordBreak("catsandog", List.of("cats","dog","sand","and","cat"));
    }

    /**
     *
     * 解题思路：
     * 1、暴力解决，回溯处理
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict) {
       set = new HashSet<>(wordDict);
        return  word(s,wordDict,0);
    }

    private boolean word(String s, List<String> wordDict, int index) {
        if(set.contains(s) || Objects.equals(s, "")){
            return true;
        }
        for (int i = index; i < wordDict.size(); i++) {
            String temp = wordDict.get(i);
            if(s.contains(temp)){
                String[] split = s.split(temp);
                boolean word = true;
                for (String sub : split) {
                    word = word(sub, wordDict, index) && word;
                }
                if(word){
                    return true;
                }
            }
        }
        return false;

    }

    Set<String> set;


    public boolean wordBreak1(String s, List<String> wordDict) {
        int[] cache = new int[s.length()];
        return dfs(s, wordDict, 0, cache);
    }

    private boolean dfs(String s, List<String> wordDict, int start, int[] cache) {
        if (start == s.length()) {
            return true;
        }
        if (cache[start] > 0) {
            return cache[start] == 1;
        }
        for (String word : wordDict) {
            if (s.startsWith(word, start) && dfs(s, wordDict, start + word.length(), cache)) {
                cache[start] = 1;
                return true;
            }
        }
        cache[start] = 2;
        return false;
    }
}
