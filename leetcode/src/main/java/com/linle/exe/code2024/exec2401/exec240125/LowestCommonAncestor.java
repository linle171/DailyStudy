package com.linle.exe.code2024.exec2401.exec240125;

import com.linle.exe.common.TreeNode;
import org.junit.Test;

/**
 * @description: 236. 二叉树的最近公共祖先 middle
 * @author: chendeli
 * @date: 2024-01-25 21:00
 */
public class LowestCommonAncestor {
    /**
     * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
     * <p>
     * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
     * <p>
     * 示例 1：
     * <p>
     * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
     * 输出：3
     * 解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
     * 示例 2：
     * <p>
     * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
     * 输出：5
     * 解释：节点 5 和节点 4 的最近公共祖先是节点 5 。因为根据定义最近公共祖先节点可以为节点本身。
     * 示例 3：
     * <p>
     * 输入：root = [1,2], p = 1, q = 2
     * 输出：1
     * <p>
     * 提示：
     * <p>
     * 树中节点数目在范围 [2, 105] 内。
     * -109 <= Node.val <= 109
     * 所有 Node.val 互不相同 。
     * p != q
     * p 和 q 均存在于给定的二叉树中。
     */
    @Test
    public void test() {
    }

    /**
     * 解题思路：
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        lowest(root, p, q);
        return node;
    }

    int count = 0;
    TreeNode node;

    private Boolean lowest(TreeNode root, TreeNode p, TreeNode q) {
        if (count > 0) {
            return false;
        }
        if (root == null) {
            return false;
        }
        Boolean left = lowest(root.left, p, q);
        Boolean right = lowest(root.right, p, q);
        if(left && right){
            node = root;
            count++;
        }
        if (root == p || root == q) {
            if(left || right){
                node = root;
                count++;
            }else {
                return true;
            }
        }
        return left || right;
    }

    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        TreeNode left = lowestCommonAncestor1(root.left, p, q);
        TreeNode right = lowestCommonAncestor1(root.right, p, q);
        if (root == p || root == q) {
            return root;
        }
        if (left != null && right != null) {
            return root;
        } else if (left != null) {
            return left;
        } else if (right != null) {
            return right;
        }
        return null;
    }
}
