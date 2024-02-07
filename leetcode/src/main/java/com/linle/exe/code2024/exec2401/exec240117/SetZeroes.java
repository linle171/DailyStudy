package com.linle.exe.code2024.exec2401.exec240117;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 73. 矩阵置零 middle
 * @author: chendeli
 * @date: 2024-01-17 11:24
 */
public class SetZeroes {
    /**
     * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
     * <p>
     * 示例 1：
     * <p>
     * 输入：matrix = [[1,1,1],[1,0,1],[1,1,1]]
     * 输出：[[1,0,1],[0,0,0],[1,0,1]]
     * 示例 2：
     * <p>
     * 输入：matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
     * 输出：[[0,0,0,0],[0,4,5,0],[0,3,1,0]]
     * <p>
     * 提示：
     * <p>
     * m == matrix.length
     * n == matrix[0].length
     * 1 <= m, n <= 200
     * -2^31 <= matrix[i][j] <= 2^31 - 1
     * <p>
     * 进阶：
     * <p>
     * 一个直观的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
     * 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
     * 你能想出一个仅使用常量空间的解决方案吗？
     */
    @Test
    public void test(){
        setZeroes(new int[][]{{0,1,0},{1,1,1},{1,1,1}});
    }

    /**
     * 解题思路：记录 为0的行列index就行,使用了map记录为0的index
     *
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
        int col = matrix.length;
        int row = matrix[0].length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    if (!map.containsKey(i)) {
                        map.put(i, 0);
                    } else {
                        if (map.get(i) != 0 && map.get(i) < 2) {
                            map.put(i, map.get(i)+1);
                        }
                    }

                    if (!map.containsKey(j)) {
                        map.put(j, 1);
                    } else {
                        if (map.get(i) != 1 && map.get(i) < 2) {
                            map.put(j, map.get(j)  +2);
                        }
                    }
                }
            }
        }
        for (Integer i : map.keySet()) {
            int c = -1, r = -1;
            Integer temp = map.get(i);
            if (temp == 2) {
                c = col;
                r = row;
            } else if (temp == 0) {
                r = row;
            } else {
                c = col;
            }
            while (r-- > 0) {
                matrix[i][r] = 0;
            }
            while (c-- > 0) {
                matrix[c][i] = 0;
            }
        }
    }

    /**
     * 解题思路：记录 为0的行列index就行
     * 不适用额外的空间，需要在原数组里面记录为0的index
     * 1、遍历matrix[0][i] 和 matrix[i][0] 判断 第一行和第一列是否有0
     * 2、再次遍历matrix[i][j] i>0,j>0 若是matrix[i][j]==0 那么设置matrix[0][j]=0 和 matrix[i][0]=0;就是把为0的记录在第一行和第一列
     *
     * @param matrix
     */
    public void setZeroes1(int[][] matrix) {

    }
}
