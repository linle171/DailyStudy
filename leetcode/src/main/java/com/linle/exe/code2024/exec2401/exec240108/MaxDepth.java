package com.linle.exe.code2024.exec2401.exec240108;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.List;
import java.util.logging.Level;

/**
 * @description: 104. 二叉树的最大深度 simple
 * @author: chendeli
 * @date: 2024-01-08 22:00
 */
public class MaxDepth {
    /**
     * 给定一个二叉树 root ，返回其最大深度。
     *
     * 二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。
     *
     * 示例 1：
     *
     * 输入：root = [3,9,20,null,null,15,7]
     * 输出：3
     * 示例 2：
     *
     * 输入：root = [1,null,2]
     * 输出：2
     *
     * 提示：
     *
     * 树中节点的数量在 [0, 104] 区间内。
     * -100 <= Node.val <= 100
     */
    @Test
    public void test() {
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
     * 动态规划： f(n) = Math.max(f(l),f(r));
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }

        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        int depth = 1;
        while(!deque.isEmpty()){
            List<TreeNode> list = deque.stream().toList();
            deque.clear();
            for (TreeNode treeNode : list) {
                if(treeNode.left != null) {
                    deque.add(treeNode.left);
                }
                if(treeNode.right != null){
                    deque.add(treeNode.right);
                }
            }
            depth++;
        }
        return depth;
    }

    public int maxDepth1(TreeNode root) {
        if(root == null){
            return 0;
        }
        return getDepth(root,0);
    }

    private int getDepth(TreeNode root, int depth) {
        if(root == null){
            return depth;
        }
        int l = getDepth(root.left, depth+1);
        int r = getDepth(root.right, depth+1);
        return Math.max(l,r);
    }

}
