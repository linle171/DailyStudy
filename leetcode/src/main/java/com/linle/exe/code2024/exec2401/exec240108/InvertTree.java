package com.linle.exe.code2024.exec2401.exec240108;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Vector;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @description: 226. 翻转二叉树 simple
 * @author: chendeli
 * @date: 2024-01-08 21:09
 */
public class InvertTree {
    /**
     * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
     * <p>
     * 示例 1：
     * <p>
     * 输入：root = [4,2,7,1,3,6,9]
     * 输出：[4,7,2,9,6,3,1]
     * 示例 2：
     * <p>
     * 输入：root = [2,1,3]
     * 输出：[2,3,1]
     * 示例 3：
     * <p>
     * 输入：root = []
     * 输出：[]
     * <p>
     * 提示：
     * <p>
     * 树中节点数目范围在 [0, 100] 内
     * -100 <= Node.val <= 100
     */
    @Test
    public void test() {
        String s = "   -42";
        System.out.println(0);
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {
        }
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 解题思路：就是左右节点互换
     */
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return root;
        }
        TreeNode temp;
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        while(!deque.isEmpty()){
            TreeNode pop = deque.pop();
            if(pop.left != null) {
                deque.add(pop.left);
            }
            if(pop.right != null){
                deque.add(pop.right);
            }
            temp = pop.left;
            pop.left = pop.right;
            pop.right = temp;
        }
        return root;
    }
}
