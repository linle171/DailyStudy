package com.linle.exe.code2024.exec2401.exec240122;

import com.linle.exe.common.TreeNode;
import org.checkerframework.checker.units.qual.A;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.Vector;

/**
 * @description: 94. 二叉树的中序遍历 simple
 * @author: chendeli
 * @date: 2024-01-22 10:03
 */
public class InorderTraversal {
    /**
     * 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
     *
     * 示例 1：
     *
     * 输入：root = [1,null,2,3]
     * 输出：[1,3,2]
     * 示例 2：
     *
     * 输入：root = []
     * 输出：[]
     * 示例 3：
     *
     * 输入：root = [1]
     * 输出：[1]
     *
     * 提示：
     *
     * 树中节点数目在范围 [0, 100] 内
     * -100 <= Node.val <= 100
     *
     * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
     */
    @Test
    public void test(){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        inorderTraversal1(root);
    }


    List<Integer> list = new ArrayList<>();
    /**
     * 解题思路: 1、递归
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        inorder(root) ;
        return list;

    }

    private void inorder(TreeNode root) {
        if(root == null)return;
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }

    /**
     * 2、迭代
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> l = new ArrayList<>();
        if(root == null){
            return l;
        }
        TreeNode temp = root;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(temp);
        while(!stack.isEmpty()) {
            TreeNode left = stack.peek().left;
            while (left != null) {
                stack.push(left);
                left = left.left;
            }
            TreeNode pop = stack.pop();
            l.add(pop.val);
            while(pop.right == null && !stack.isEmpty()){
                pop = stack.pop();
                l.add(pop.val);
            }
            if(pop.right == null){
                break;
            }
            stack.push(pop.right);
        }
        return l;

    }

}
