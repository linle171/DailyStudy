package com.linle.exe.code2024.exec2401.exec240106;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @description: 20. 有效的括号 simple
 * @author: chendeli
 * @date: 2024-01-06 09:59
 */
public class IsValid {
    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
     * <p>
     * 有效字符串需满足：
     * <p>
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 每个右括号都有一个对应的相同类型的左括号。
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：s = "()"
     * 输出：true
     * 示例 2：
     * <p>
     * 输入：s = "()[]{}"
     * 输出：true
     * 示例 3：
     * <p>
     * 输入：s = "(]"
     * 输出：false
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= s.length <= 104
     * s 仅由括号 '()[]{}' 组成
     *
     * @param
     * @return
     */
    @Test
    public void test() {

    }


    /**
     * 利用栈 先入后出规则
     * fifo
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        Stack<Character> sk = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                sk.push(c);
            }
            if (c == ')' || c == '}' || c == ']') {
                Character wife = map.get(c);
                if (sk.isEmpty()) {
                    return false;
                } else {
                    Character pop = sk.pop();
                    if (pop != wife) {
                        return false;
                    }
                }
            }

        }
        return sk.isEmpty();
    }
}
