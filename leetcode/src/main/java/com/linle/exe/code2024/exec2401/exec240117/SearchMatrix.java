package com.linle.exe.code2024.exec2401.exec240117;

import org.junit.Test;


/**
 * @description: 240. 搜索二维矩阵 II middle
 * @author: chendeli
 * @date: 2024-01-17 17:49
 */
public class SearchMatrix {
    /**
     * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
     * <p>
     * 每行的元素从左到右升序排列。
     * 每列的元素从上到下升序排列。
     * <p>
     * 示例 1：
     * <p>
     * 输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
     * 输出：true
     * 示例 2：
     * <p>
     * 输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
     * 输出：false
     * <p>
     * 提示：
     * <p>
     * m == matrix.length
     * n == matrix[i].length
     * 1 <= n, m <= 300
     * -10^9 <= matrix[i][j] <= 10^9
     * 每行的所有元素从左到右升序排列
     * 每列的所有元素从上到下升序排列
     * -10^9 <= target <= 10^9
     */
    @Test
    public void test() {
        boolean b = searchMatrix(new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}}, 5);
        System.out.println(b);

    }

    /**
     * 解题思路：每一行二分查找 O(nlogn)  z自行查找O(m+n)
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        int i=n-1,j=0;
        int p=0,q=m-1;
        while (i>=p && q>=j){
            int leftNum = matrix[i][j];
            if(leftNum == target){
                return true;
            }else if(leftNum >target){
                i--;
            }else {
                j++;
            }
            int rightNum = matrix[p][q];
            if(rightNum == target){
                return true;
            }else if(rightNum >target){
                q--;
            }else {
                p++;
            }
        }
        return false;

    }


}
