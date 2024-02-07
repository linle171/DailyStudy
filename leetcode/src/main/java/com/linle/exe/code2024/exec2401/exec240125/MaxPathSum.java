package com.linle.exe.code2024.exec2401.exec240125;

import com.linle.exe.common.TreeNode;
import org.junit.Test;

/**
 * @description: 124. 二叉树中的最大路径和 difficult
 * @author: chendeli
 * @date: 2024-01-25 23:07
 */
public class MaxPathSum {
    /**
     * 二叉树中的 路径 被定义为一条节点序列，序列中每对相邻节点之间都存在一条边。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
     * <p>
     * 路径和 是路径中各节点值的总和。
     * <p>
     * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
     * <p>
     * 示例 1：
     * <p>
     * 输入：root = [1,2,3]
     * 输出：6
     * 解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6
     * 示例 2：
     * <p>
     * 输入：root = [-10,9,20,null,null,15,7]
     * 输出：42
     * 解释：最优路径是 15 -> 20 -> 7 ，路径和为 15 + 20 + 7 = 42
     * <p>
     * 提示：
     * <p>
     * 树中节点数目范围是 [1, 3 * 104]
     * -1000 <= Node.val <= 1000
     */
    @Test
    public void test() {
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.left.left = new TreeNode(3);
//        root.left.left.left = new TreeNode(4);
//        root.left.left.left.left  = new TreeNode(5);
//        root.left.left.left.left.left = new TreeNode(1000000000);
//        root.left .left.left.left.left.left= new TreeNode(1000000000);
        maxPathSum(root);
    }

    /**
     * 解题思路：
     *
     * @param root
     * @return
     */
    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        int maxPath = maxPath(root);
        return Math.max(maxPath,max);
    }

    private int maxPath(TreeNode root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        int l = maxPath(root.left);
        int r = maxPath(root.right);
        max = Math.max(max,Math.max(l,r));
        int maxT = root.val;
        if (l < 0 && r < 0) {
            return maxT;
        }
        max = Math.max(l+r+maxT,max);
        return maxT + Math.max(l, r);
    }


    int res = Integer.MIN_VALUE;

    public int maxPathSum1(TreeNode root) {
        dfs(root);
        return res;
    }

    // 返回当前节点能为父亲提供的贡献
    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        res = Math.max(res, left + right + root.val);
        int value = root.val + Math.max(left, right);
        return value > 0 ? value : 0;
    }

}
