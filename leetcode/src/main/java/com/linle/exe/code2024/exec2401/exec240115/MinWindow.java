package com.linle.exe.code2024.exec2401.exec240115;

import org.checkerframework.checker.units.qual.A;
import org.junit.Test;

import java.util.*;

/**
 * @description: 76. 最小覆盖子串 difficult
 * @author: chendeli
 * @date: 2024-01-15 21:26
 */
public class MinWindow {
    /**
     * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
     *
     * 注意：
     *
     * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
     * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
     *
     * 示例 1：
     *
     * 输入：s = "ADOBECODEBANC", t = "ABC"
     * 输出："BANC"
     * 解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
     * 示例 2：
     *
     * 输入：s = "a", t = "a"
     * 输出："a"
     * 解释：整个字符串 s 是最小覆盖子串。
     * 示例 3:
     *
     * 输入: s = "a", t = "aa"
     * 输出: ""
     * 解释: t 中两个字符 'a' 均应包含在 s 的子串中，
     * 因此没有符合条件的子字符串，返回空字符串。
     *
     * 提示：
     *
     * m == s.length
     * n == t.length
     * 1 <= m, n <= 10^5
     * s 和 t 由英文字母组成
     */
    @Test
    public void test(){
        minWindow("acbdbaab","aabd");
    }

    /**
     *
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {
        int len = t.length();
        Map<Character,Integer> map = new HashMap<>(len);
        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i),map.getOrDefault(t.charAt(i),0)+1);
        }
        String min = "";
        Integer minLength = Integer.MAX_VALUE;

        //保存下标
        Map<Character,List<Integer>> mapWindow = new LinkedHashMap<>(t.length());
        //保存先后顺序
        Deque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i <s.length(); i++) {
            char c = s.charAt(i);
            if(map.containsKey(c)){
                Integer count = map.get(c);
                if(count == 0){
                    List<Integer> list = mapWindow.get(c);
                    list.remove(0);
                    list.add(i);
                    deque.removeFirstOccurrence(c);
                    deque.add(c);
                }else {
                    List<Integer> orDefault = mapWindow.getOrDefault(c, new ArrayList<>());
                    orDefault.add(i);
                    mapWindow.put(c,orDefault);
                    map.put(c,map.get(c)-1);
                    deque.add(c);
                    if(deque.size() == len){
                        if(minLength > i - mapWindow.get(deque.peekFirst()).get(0)){
                            minLength = i - mapWindow.get(deque.peekFirst()).get(0);
                            min = s.substring(mapWindow.get(deque.peekFirst()).get(0),i+1);
                        }
                        Character first = deque.pollFirst();
                        mapWindow.get(first).remove(0);
                        map.put(first,map.get(first)+1);
                    }
                }
            }

        }
        return min;
    }

}
