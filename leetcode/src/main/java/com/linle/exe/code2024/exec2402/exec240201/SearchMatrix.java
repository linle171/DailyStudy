package com.linle.exe.code2024.exec2402.exec240201;

import org.junit.Test;

/**
 * @description: 74. 搜索二维矩阵 middle
 * @author: chendeli
 * @date: 2024-02-01 15:21
 */
public class SearchMatrix {
    /**
     * 给你一个满足下述两条属性的 m x n 整数矩阵：
     *
     * 每行中的整数从左到右按非严格递增顺序排列。
     * 每行的第一个整数大于前一行的最后一个整数。
     * 给你一个整数 target ，如果 target 在矩阵中，返回 true ；否则，返回 false 。
     *
     * 示例 1：
     *
     * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
     * 输出：true
     * 示例 2：
     *
     * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
     * 输出：false
     *
     * 提示：
     *
     * m == matrix.length
     * n == matrix[i].length
     * 1 <= m, n <= 100
     * -104 <= matrix[i][j], target <= 104
     */
    @Test
    public void test(){
//        boolean b = searchMatrix(new int[][]{{1, 3, 5, 7}, {110, 11, 16, 20}, {23, 30, 34, 60}}, 3);
        boolean b = searchMatrix(new int[][]{{1, 1}}, 3);
        System.out.println(b);
    }

    /**
     *
     * 解题思路：
     * 1、
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int col = matrix.length;
        int row = matrix[0].length;
        int l = 0;
        int r = col*row-1;
        while(l <= r){
            int mid = l + ((r-l) >> 1);
            int i = mid / row;
            int j = (mid-i*row);
            if(matrix[i][j] == target){
                return true;
            }else if(matrix[i][j] > target){
                r = mid -1;
            }else {
                l = mid+1;
            }
        }
        return false;
    }
}
