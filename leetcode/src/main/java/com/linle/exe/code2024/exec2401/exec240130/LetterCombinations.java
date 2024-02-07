package com.linle.exe.code2024.exec2401.exec240130;

import com.google.common.collect.Lists;
import org.checkerframework.checker.units.qual.A;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 17. 电话号码的字母组合 middle
 * @author: chendeli
 * @date: 2024-01-30 16:02
 */
public class LetterCombinations {
    /**
     * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
     *
     * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
     *
     * 示例 1：
     *
     * 输入：digits = "23"
     * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
     * 示例 2：
     *
     * 输入：digits = ""
     * 输出：[]
     * 示例 3：
     *
     * 输入：digits = "2"
     * 输出：["a","b","c"]
     *
     * 提示：
     *
     * 0 <= digits.length <= 4
     * digits[i] 是范围 ['2', '9'] 的一个数字
     */
    @Test
    public void test(){
        letterCombinations("23");
    }

    /**
     *
     * 解题思路：
     * 1、
     * @param digits
     * @return
     */
    static List<List<String>> list ;
    static {
        list = new ArrayList<>();

        list.add(List.of("a","b","c"));
        list.add(List.of("d","e","f"));
        list.add(List.of("g","h","i"));
        list.add(List.of("j","k","l"));
        list.add(List.of("m","n","o"));
        list.add(List.of("p","q","r","s"));
        list.add(List.of("t","u","v"));
        list.add(List.of("w","x","y","z"));
    }
    List<String> l;
    public List<String> letterCombinations(String digits) {
        l = new ArrayList<>();
        if(digits.isBlank()){
            return new ArrayList<>();
        }
        letter(digits,0,new StringBuffer(""));
        return l;
    }

    private void letter(String digits, int index, StringBuffer sb) {
        if(index == digits.length()){
            l.add(sb.toString());
            return;
        }
        List<String> s = list.get(digits.charAt(index) - '2');
        for (int i = 0; i < s.size(); i++) {
            sb.append(s.get(i));
            letter(digits,index+1,sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
