package com.linle.exe.code2024.exec2401.exec240114;

import org.junit.Test;

import java.util.*;

/**
 * @description: 438. 找到字符串中所有字母异位词 middle
 * @author: chendeli
 * @date: 2024-01-14 18:09
 */
public class FindAnagrams {
    /**
     * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
     *
     * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
     *
     * 示例 1:
     *
     * 输入: s = "cbaebabacd", p = "abc"
     * 输出: [0,6]
     * 解释:
     * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
     * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
     *  示例 2:
     *
     * 输入: s = "abab", p = "ab"
     * 输出: [0,1,2]
     * 解释:
     * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
     * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
     * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
     *
     * 提示:
     *
     * 1 <= s.length, p.length <= 3 * 104
     * s 和 p 仅包含小写字母
     */
    @Test
    public void test(){
        String s = "abacbabc";
        String p = "abc";
        findAnagrams(s,p);
    }

    public List<Integer> findAnagrams(String s, String p) {
        int pLen = p.length();
        Map<Character,Integer> map = new HashMap<>(pLen);
        for (int i = 0; i < pLen; i++) {
            char c = p.charAt(i);
            Integer temp = 1;
            if(map.containsKey(c)){
                temp = map.get(c) + 1;
            }
            map.put(c,temp);
        }
        List<Integer> list = new ArrayList<>();
        Deque<Character> deque =  new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Integer temp;
            if(map.containsKey(c)){
                 temp = map.get(c);
                 if(temp == 0){
                     while( !deque.isEmpty() ){
                         Character first = deque.pollFirst();
                         Integer i1 = map.get(first);
                         if( first == c){
                             break;
                         }
                         map.put(first,i1+1);
                     }
                 }else {
                     map.put(c,temp-1);
                 }
                deque.addLast(c);
            }else {
                while(!deque.isEmpty()){
                    Character first = deque.pollFirst();
                    Integer t = map.get(first);
                    map.put(first,t+1);
                }
            }
            if(deque.size() == pLen){
              list.add(i- pLen +1);
            }
        }
        return list;

    }
}
