package com.linle.exe.code2024.exec2402.exec240201;

import org.checkerframework.checker.units.qual.A;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 51. N 皇后 difficult
 * @author: chendeli
 * @date: 2024-02-01 10:20
 */
public class SolveNQueens {
    /**
     * 按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。
     * <p>
     * n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
     * <p>
     * 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
     * <p>
     * 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
     * <p>
     * 示例 1：
     * <p>
     * 输入：n = 4
     * 输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
     * 解释：如上图所示，4 皇后问题存在两个不同的解法。
     * 示例 2：
     * <p>
     * 输入：n = 1
     * 输出：[["Q"]]
     * <p>
     * 提示：
     * <p>
     * 1 <= n <= 9
     */
    @Test
    public void test() {
        solveNQueens(4);
    }

    /**
     * 解题思路：
     * 1|
     *
     * @param n
     * @return
     */
    List<List<String>> list = new ArrayList<>();
    StringBuilder sb = new StringBuilder();

    public List<List<String>> solveNQueens(int n) {
        boolean[][] isResult = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            sb.append(".");
        }
        solve(isResult, n, 0, new ArrayList<>());
        return list;
    }

    private void solve(boolean[][] isResult, int n, int index, List<String> l) {
        if (index == n) {
            list.add(new ArrayList<>(l));
        }
        for (int i = 0; i < n; i++) {
            if(!isPass(index,i,isResult)) {
                isResult[index][i] = true;
                StringBuilder s = new StringBuilder(sb);
                s.setCharAt(i, 'Q');
                l.add(s.toString());
                solve(isResult, n, index + 1, l);
                l.remove(l.size() - 1);
                isResult[index][i] = false;
            }
        }
    }

    private boolean isPass(int index, int i, boolean[][] isResult) {
        boolean isFlag = false;
        for (int j = 0; j < index; j++) {
           if(i - (j+1) >= 0){
               isFlag = isFlag || isResult[index-j-1][i-(j+1)];
           }
           if(i+(j+1) <isResult.length){
               isFlag = isFlag || isResult[index-j-1][i+(j+1)];
           }
           isFlag = isFlag || isResult[index-j-1][i];
           if(isFlag){
               return true;
           }
        }
        return false;
    }
}
