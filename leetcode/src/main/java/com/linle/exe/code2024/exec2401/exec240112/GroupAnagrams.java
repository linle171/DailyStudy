package com.linle.exe.code2024.exec2401.exec240112;

import org.junit.Test;

import java.util.*;

/**
 * @description: 49. 字母异位词分组 middle
 * @author: chendeli
 * @date: 2024-01-13 09:24
 */
public class GroupAnagrams {
    /**
     * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
     *
     * 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
     *
     * 示例 1:
     *
     * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
     * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
     * 示例 2:
     *
     * 输入: strs = [""]
     * 输出: [[""]]
     * 示例 3:
     *
     * 输入: strs = ["a"]
     * 输出: [["a"]]
     *
     * 提示：
     *
     * 1 <= strs.length <= 104
     * 0 <= strs[i].length <= 100
     * strs[i] 仅包含小写字母
     * @return
     */
    @Test
    public void test(){
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        groupAnagrams(strs);
    }

    /**
     * 解题思路：得到异位词共同的key 通过数组O(n)排序
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for(int i = 0; i<strs.length; i++){
            String s = strs[i];
            int[] amount =   new int[26];
            for(int j =0; j<s.length();j++){
               amount[s.charAt(j)-'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int k = 0; k < amount.length; k++) {
                int temp = amount[k];
                sb.append(k+'a'+temp);
            }
            List<String> list;
            if(map.containsKey(sb.toString())){
                list = map.get(sb.toString());
                list.add(s);
            }else{
                list = new ArrayList<>();
                list.add(s);
            }
            map.put(sb.toString(),list);

        }
        return map.values().stream().toList();
    }
}
