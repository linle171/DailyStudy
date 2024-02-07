package com.linle.exe.code2024.exec2401.exec240125;

import com.linle.exe.common.TreeNode;
import org.checkerframework.checker.units.qual.A;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @description: 437. 路径总和 III middle
 * @author: chendeli
 * @date: 2024-01-25 19:11
 */
public class PathSum {
    /**
     * 给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
     * <p>
     * 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
     * <p>
     * 示例 1：
     * <p>
     * 输入：root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
     * 输出：3
     * 解释：和等于 8 的路径有 3 条，如图所示。
     * 示例 2：
     * <p>
     * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
     * 输出：3
     * <p>
     * 提示:
     * <p>
     * 二叉树的节点个数的范围是 [0,1000]
     * -109 <= Node.val <= 109
     * -1000 <= targetSum <= 1000
     */
    @Test
    public void test() {
        TreeNode root = new TreeNode(1000000000);
        root.left = new TreeNode(1000000000);
        root.left.left = new TreeNode(294967296);
        root.left.left.left = new TreeNode(1000000000);
        root.left.left.left.left  = new TreeNode(1000000000);
        root.left.left.left.left.left = new TreeNode(1000000000);
        root.left .left.left.left.left.left= new TreeNode(1000000000);
        pathSum(root,0);
    }

    /**
     * 解题思路：
     *
     * @param root
     * @param targetSum
     * @return
     */
    int count = 0;
    public int pathSum(TreeNode root, int targetSum) {
        path(root,targetSum);
        return count;
    }

    private  Deque<Integer> path(TreeNode root, int targetSum) {
        if (root == null) {
            return new ArrayDeque<>();
        }
        if(root.left == null && root.right == null){
            if(root.val == targetSum){
                count++;
            }
            Deque<Integer> temp =  new ArrayDeque<>();
            temp.add(root.val);
            return temp;
        }
        Deque<Integer> left = path(root.left, targetSum);
        Deque<Integer> right = path(root.right, targetSum);
        int size = left.size();
        int val = root.val;
        left.addLast(val);
        if(root.val == targetSum){
            count++;
        }
        while(size-->0){
            Integer pop = left.pop();
            if((long)val + (long)pop > (long) Integer.MAX_VALUE || (long)val + (long)pop < (long) Integer.MIN_VALUE ){
                continue;
            }
            int temp = pop + val;
            if(temp == targetSum){
                count++;
            }
            left.addLast(pop + val);
        }

        int sizeL = right.size();
        while(sizeL-->0){
            Integer pop = right.pop();
            if((long)val + (long)pop > (long) Integer.MAX_VALUE || (long)val + (long)pop < (long) Integer.MIN_VALUE ){
                continue;
            }
            int temp = pop + val;
            if(temp == targetSum){
                count++;
            }
            left.addLast(pop + val);
        }

        return left;
    }
}
