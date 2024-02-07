package com.linle.exe.code2024.exec2402.exec240203;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 118. 杨辉三角 simple
 * @author: chendeli
 * @date: 2024-02-03 23:28
 */
public class Generate {
    /**
     * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
     * <p>
     * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
     * <p>
     * 示例 1:
     * <p>
     * 输入: numRows = 5
     * 输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
     * 示例 2:
     * <p>
     * 输入: numRows = 1
     * 输出: [[1]]
     * <p>
     * 提示:
     * <p>
     * 1 <= numRows <= 30
     */
    @Test
    public void test() {
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> l = new ArrayList<>();
        l.add(List.of(1));
        if (numRows == 1) {
            return l;
        }
        l.add(List.of(1, 1));
        if (numRows == 2) {
            return l;
        }
        for (int i = 2; i < numRows; i++) {
            List<Integer> temp = new ArrayList<>();
            temp.add(1);
            List<Integer> list = l.get(i - 1);
            for (int j = 1; j < i; j++) {
                temp.add(list.get(j-1)+ list.get(j));
            }
            temp.add(1);
            l.add(temp);
        }
        return l;

    }
}
