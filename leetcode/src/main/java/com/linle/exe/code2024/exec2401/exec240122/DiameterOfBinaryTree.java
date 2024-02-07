package com.linle.exe.code2024.exec2401.exec240122;

import com.linle.exe.common.TreeNode;
import org.junit.Test;

/**
 * @description: 543. 二叉树的直径 simple
 * @author: chendeli
 * @date: 2024-01-22 21:57
 */
public class DiameterOfBinaryTree {
    /**
     * 给你一棵二叉树的根节点，返回该树的 直径 。
     *
     * 二叉树的 直径 是指树中任意两个节点之间最长路径的 长度 。这条路径可能经过也可能不经过根节点 root 。
     *
     * 两节点之间路径的 长度 由它们之间边数表示。
     *
     * 示例 1：
     *
     * 输入：root = [1,2,3,4,5]
     * 输出：3
     * 解释：3 ，取路径 [4,2,1,3] 或 [5,2,1,3] 的长度。
     * 示例 2：
     *
     * 输入：root = [1,2]
     * 输出：1
     *
     * 提示：
     *
     * 树中节点数目在范围 [1, 104] 内
     * -100 <= Node.val <= 100
     */
    @Test
    public void test(){
        TreeNode t = new TreeNode(1);
        t.left = new TreeNode(2);
        diameterOfBinaryTree(t);
    }

    int maxLong = 0;

    /**
     *
     * 解题思路：
     *
     * @param root
     * @return
     */

    public int diameterOfBinaryTree(TreeNode root) {
        diameter(root);
        return maxLong;
    }
    private int diameter(TreeNode root) {
        if(root == null){
            return 0;
        }
        int l = diameterOfBinaryTree(root.left);
        int r = diameterOfBinaryTree(root.right);
        maxLong = Math.max(maxLong,l+r);
        return Math.max(l,r)+1;
    }
}
