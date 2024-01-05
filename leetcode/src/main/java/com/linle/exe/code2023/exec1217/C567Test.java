package com.linle.exe.code2023.exec1217;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author chendeli
 * @Description: 字符串的排序
 * @date 2022/12/16 10:14
 */
public class C567Test {


    /**
     * 给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。
     *
     * 换句话说，s1 的排列之一是 s2 的 子串 。
     *
     * 提示：
     *
     * 1 <= s1.length, s2.length <= 104
     * s1 和 s2 仅包含小写字母
     */
    @Test
    public void test567() {
        String s1 ="ab";
        String s2 = "eidbaooo";
        int[] map1 = new int[26];
        int[] map2 = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            map1[s1.charAt(i)-'a']++;
            map2[s2.charAt(i)-'a']++;
        }
        for (int i = 0; i <=s2.length()-s1.length(); i++) {
            if(s2.charAt(i) == s2.charAt(i+s1.length()) ){
                continue;
            }
            if(Arrays.equals(map1 , map2)){
                System.out.println("---");
                return;
            }else {
                map2[s2.charAt(i)-'a']--;
                map2[s2.charAt(i+ s1.length())-'a']++;
            }
        }

        return;
    }
}
