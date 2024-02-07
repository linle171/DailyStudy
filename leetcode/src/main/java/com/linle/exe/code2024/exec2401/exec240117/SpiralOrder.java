package com.linle.exe.code2024.exec2401.exec240117;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 54. 螺旋矩阵 middle
 * @author: chendeli
 * @date: 2024-01-17 13:48
 */
public class SpiralOrder {
    /**
     * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
     *
     * 示例 1：
     *
     * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
     * 输出：[1,2,3,6,9,8,7,4,5]
     * 示例 2：
     *
     * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
     * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
     *
     * 提示：
     *
     * m == matrix.length
     * n == matrix[i].length
     * 1 <= m, n <= 10
     * -100 <= matrix[i][j] <= 100
     */
    @Test
    public void test(){}

    /**
     * 解题思路：
     * 1、记录范围过的坐标
     * 2、若右边的没有访问过，先往右走；右边访问过在判断下边的数据，下边的没有访问过，先往下走；下边访问过在判断左边的数据，左边的没有访问过，先往左走；左边访问过在判断上边的数据，上边的没有访问过，先往下走
     * 3、终止条件，所有的都被访问过
     *
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        int col = matrix.length;
        int row = matrix[0].length;
        List<Integer> result = new ArrayList<>(col*row);
        int n=0,m=0;
        Boolean isUp = false;
        while(true){
            result.add(matrix[n][m]);
            matrix[n][m] = 101;
            if(isUp){
                if(n-1>=0 && matrix[n-1][m] != 101){
                    n--;
                    continue;
                }else {
                    isUp = false;
                }
            }
            //先往右走
            if(  m+1<row && matrix[n][m+1] != 101){
                m++;
                continue;
            }
            //再往下走
            if(n+1<col && matrix[n+1][m] != 101){
                n++;
                continue;
            }
            //再往左走
            if(m-1>=0 && matrix[n][m-1] != 101){
                m--;
                continue;
            }
            //再往上走
            if(n-1>=0 && matrix[n-1][m] != 101){
                n--;
                isUp = true;
                continue;
            }
            break;
        }
        return result;
    }
}
