package com.linle.exe.code2024.exec2401.exec240109;

import cn.hutool.core.util.ReUtil;
import org.junit.Test;

import java.util.Random;
import java.util.logging.Level;

/**
 * @description: 112. 路径总和 simple
 * @author: chendeli
 * @date: 2024-01-09 11:17
 */
public class HasPathSum {

    /**
     * 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum 。判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。如果存在，返回 true ；否则，返回 false 。
     *
     * 叶子节点 是指没有子节点的节点。
     *
     * 示例 1：
     *
     * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
     * 输出：true
     * 解释：等于目标和的根节点到叶节点路径如上图所示。
     * 示例 2：
     *
     * 输入：root = [1,2,3], targetSum = 5
     * 输出：false
     * 解释：树中存在两条根节点到叶子节点的路径：
     * (1 --> 2): 和为 3
     * (1 --> 3): 和为 4
     * 不存在 sum = 5 的根节点到叶子节点的路径。
     * 示例 3：
     *
     * 输入：root = [], targetSum = 0
     * 输出：false
     * 解释：由于树是空的，所以不存在根节点到叶子节点的路径。
     *
     * 提示：
     *
     * 树中节点的数目在范围 [0, 5000] 内
     * -1000 <= Node.val <= 1000
     * -1000 <= targetSum <= 1000
     */
    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.left.left = new TreeNode(3);
//        root.left.left.left = new TreeNode(4);
//        root.left.left.left.left = new TreeNode(5);
        boolean validBST = hasPathSum(root,1);
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
     * 解题思路：
     * @param root 根节点到子节点的路径值  终止条件是 叶子结点（该节点的左右节点都为null）
     * @param targetSum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null){
            return false;
        }
        return getPathNum(root,targetSum,root.val);
    }

    private boolean getPathNum(TreeNode root, int targetSum, int doSum) {
        if(root.left == null && root.right == null ){
            if(doSum == targetSum){
                return true;
            }
            return false;
        }
        boolean l = false;
        boolean r = false;
        if(root.left != null) {
            l = getPathNum(root.left, targetSum, doSum + root.left.val);
        }
        if(root.right != null){
            r = getPathNum(root.right, targetSum, doSum + root.right.val);
        }
        return  l||r;
    }
}
