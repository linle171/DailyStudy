package com.linle.exe.code2024.exec2401.exec240109;

import org.checkerframework.checker.units.qual.A;
import org.checkerframework.checker.units.qual.Length;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 98. 验证二叉搜索树 middle
 * @author: chendeli
 * @date: 2024-01-09 09:26
 */
public class IsValidBST {

    /**
     * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
     * <p>
     * 有效 二叉搜索树定义如下：
     * <p>
     * 节点的左子树只包含 小于 当前节点的数。
     * 节点的右子树只包含 大于 当前节点的数。
     * 所有左子树和右子树自身必须也是二叉搜索树。
     * <p>
     * 示例 1：
     * <p>
     * 输入：root = [2,1,3]
     * 输出：true
     * 示例 2：
     * <p>
     * 输入：root = [5,1,4,null,null,3,6]
     * 输出：false
     * 解释：根节点的值是 5 ，但是右子节点的值是 4 。
     * <p>
     * 提示：
     * <p>
     * 树中节点数目范围在[1, 104] 内
     * -231 <= Node.val <= 231 - 1
     */
    @Test
    public void test() {
        TreeNode root = new TreeNode(-2147483648);
//        root.left = new TreeNode(1);
        root.right = new TreeNode(2147483647);
        boolean validBST = isValidBST(root);
        System.out.println(validBST);
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
     * 解题思路：前序遍历 判断后一个节点要大于前面的一个节点
     *
     * @param root
     * @return
     */
    long pre = (long)Integer.MIN_VALUE -1;

    public boolean isValidBST(TreeNode root) {
        if(root.left == null && root.right == null){
            return true;
        }
        return preorderTraversal(root);
    }


    private Boolean preorderTraversal(TreeNode root) {
        if (root == null) {
            return true;
        }
        Boolean l = preorderTraversal(root.left);
        if(root.val <= pre){
            return false;
        }
        pre = root.val;
        Boolean r = preorderTraversal(root.right);
        return l && r;
    }
}
