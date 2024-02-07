package com.linle.exe.code2024.exec2401.exec240131;

import org.junit.Test;

/**
 * @description: 79. 单词搜索 middle
 * @author: chendeli
 * @date: 2024-01-31 17:20
 */
public class Exist {
    /**
     * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
     * <p>
     * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
     * <p>
     * 示例 1：
     * <p>
     * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
     * 输出：true
     * 示例 2：
     * <p>
     * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
     * 输出：true
     * 示例 3：
     * <p>
     * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
     * 输出：false
     * <p>
     * 提示：
     * <p>
     * m == board.length
     * n = board[i].length
     * 1 <= m, n <= 6
     * 1 <= word.length <= 15
     * board 和 word 仅由大小写英文字母组成
     * <p>
     * 进阶：你可以使用搜索剪枝的技术来优化解决方案，使其在 board 更大的情况下可以更快解决问题？
     */
    @Test
    public void test() {
        exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'E', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCESEEEFS");
    }

    /**
     * 解题思路：
     *
     * @param board
     * @param word
     * @return
     */

    public boolean exist(char[][] board, String word) {
        return startDeal(board, word, 0);
    }

    private Boolean startDeal(char[][] board, String word, int index) {
        char c = word.charAt(index);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {

                    if(backTracking(i, j, board, index, word, new boolean[board.length][board[0].length])){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private Boolean backTracking(int i, int j, char[][] board, int index, String word, boolean[][] visitor) {
        if (index == word.length()) {
            return true;
        }
        char c = word.charAt(index);
        if (i < 0 || i > board.length - 1 || j < 0 || j > board[0].length - 1 || visitor[i][j] || c != board[i][j]) {
            return false;
        }
        visitor[i][j] = true;
        boolean b = backTracking(i + 1, j, board, index + 1, word, visitor) || backTracking(i - 1, j, board, index + 1, word, visitor)
                || backTracking(i, j - 1, board, index + 1, word, visitor) || backTracking(i, j + 1, board, index + 1, word, visitor);
        visitor[i][j] = false;
        return b;
    }
}
