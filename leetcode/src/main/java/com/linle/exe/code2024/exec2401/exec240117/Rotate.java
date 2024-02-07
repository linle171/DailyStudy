package com.linle.exe.code2024.exec2401.exec240117;

import org.junit.Test;

/**
 * @description: 48. 旋转图像 middle
 * @author: chendeli
 * @date: 2024-01-17 16:26
 */
public class Rotate {
    /**
     * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
     * <p>
     * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
     * <p>
     * 示例 1：
     * <p>
     * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
     * 输出：[[7,4,1],[8,5,2],[9,6,3]]
     * 示例 2：
     * <p>
     * 输入：matrix =  16]]
     * 输出：[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
     * <p>
     * 提示：
     * <p>
     * n == matrix.length == matrix[i].length
     * 1 <= n <= 20
     * -1000 <= matrix[i][j] <= 1000
     */
    @Test
    public void test() {
        rotate(new int[][]{{1,2,3,4},
                          { 5,6,7,8},
                          { 9,10,11,12},
                          {13,14,15,16}});
    }

    /**
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int l, r;
        if (n % 2 == 0) {
            l = n / 2 -1;
            r = l +1;
        } else {
            l = n / 2 - 1;
            r = n / 2 + 1;
        }
        //层级
        for (int i = 1; i <= n / 2; i++) {
            for (int j = l; j < r; j++) {
                int temp = matrix[l][j];
                matrix[l][j] = matrix[r - j + l][l];
                matrix[r - j + l][l] = matrix[r][r - j + l];
                matrix[r][r - j + l] = matrix[j][r];
                matrix[j][r] = temp;
            }
            l--;
            r++;
        }
        System.out.println(1);
    }
}
