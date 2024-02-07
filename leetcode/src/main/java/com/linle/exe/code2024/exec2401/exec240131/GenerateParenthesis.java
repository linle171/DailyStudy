package com.linle.exe.code2024.exec2401.exec240131;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 22. 括号生成 middle
 * @author: chendeli
 * @date: 2024-01-31 13:38
 */
public class GenerateParenthesis {
    /**
     * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
     *
     * 示例 1：
     *
     * 输入：n = 3
     * 输出：["((()))","(()())","(())()","()(())","()()()"]
     * 示例 2：
     *
     * 输入：n = 1
     * 输出：["()"]
     *
     * 提示：
     *
     * 1 <= n <= 8
     */
    @Test
    public void test(){
        generateParenthesis(3);
    }

    List<String> list = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        StringBuilder sb = new StringBuilder();
        generate(sb,n,n);
        return list;
    }

    private void generate(StringBuilder sb, int l, int r) {
        if(l == 0 && r == 0){
            list.add(sb.toString());
            return;
        }
        if(l==r){
            sb.append("(");
            generate(sb,l-1,r);
            sb.deleteCharAt(sb.length()-1);
        }else {
            if(l==0){
                sb.append(")");
                generate(sb,l,r-1);
                sb.deleteCharAt(sb.length()-1);
            }else {
                sb.append("(");
                generate(sb,l-1,r);
                sb.deleteCharAt(sb.length()-1);
                sb.append(")");
                generate(sb,l,r-1);
                sb.deleteCharAt(sb.length()-1);
            }

        }
    }
}
