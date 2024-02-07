package com.linle.exe.code2024.exec2401.exec240124;

import com.linle.exe.common.TreeNode;
import org.junit.Test;

/**
 * @description: 114. 二叉树展开为链表 middle
 * @author: chendeli
 * @date: 2024-01-24 18:37
 */
public class Flatten {
    /**
     * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
     *
     * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
     * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
     *
     * 示例 1：
     *
     * 输入：root = [1,2,5,3,4,null,6]
     * 输出：[1,null,2,null,3,null,4,null,5,null,6]
     * 示例 2：
     *
     * 输入：root = []
     * 输出：[]
     * 示例 3：
     *
     * 输入：root = [0]
     * 输出：[0]
     *
     * 提示：
     *
     * 树中结点数在范围 [0, 2000] 内
     * -100 <= Node.val <= 100
     *
     * 进阶：你可以使用原地算法（O(1) 额外空间）展开这棵树吗？
     */
    @Test
    public void test(){
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
//        root.left.right = new TreeNode(4);
//        root.left = new TreeNode(2);
//        root.left.left = new TreeNode(3);
//        root.left.right = new TreeNode(4);
//        root.right = new TreeNode(5);
//        root.right.left = new TreeNode(6);
        flatten(root);
    }

    /**
     *
     * 解题思路：
     * @param root
     */
    public void flatten(TreeNode root) {
        if(root == null){
            return;
        }
        lastNode = root;
        if(root.left != null){
            lastNode = root;
            flatten(root.left);
        }
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = null;
        lastNode.right = temp;
        if(temp != null){
            lastNode = temp;
            flatten(temp);
        }
    }

    TreeNode lastNode = null;

    private void flattenRight(TreeNode root) {

    }


}
