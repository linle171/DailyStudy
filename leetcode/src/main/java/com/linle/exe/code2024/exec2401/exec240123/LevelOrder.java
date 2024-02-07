package com.linle.exe.code2024.exec2401.exec240123;

import com.linle.exe.common.TreeNode;
import org.checkerframework.checker.units.qual.A;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @description: 102. 二叉树的层序遍历 middle
 * @author: chendeli
 * @date: 2024-01-23 22:36
 */
public class LevelOrder {
    /**
     * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
     *
     * 示例 1：
     *
     * 输入：root = [3,9,20,null,null,15,7]
     * 输出：[[3],[9,20],[15,7]]
     * 示例 2：
     *
     * 输入：root = [1]
     * 输出：[[1]]
     * 示例 3：
     *
     * 输入：root = []
     * 输出：[]
     *
     * 提示：
     *
     * 树中节点数目在范围 [0, 2000] 内
     * -1000 <= Node.val <= 1000
     */
    @Test
    public void test(){}

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list  = new ArrayList<>();
        if(root == null){
            return list;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);
        while(!deque.isEmpty()){
            int size = deque.size();
            List<Integer> l = new ArrayList<>();
            while(size-- > 0){
                TreeNode treeNode = deque.pollFirst();
                l.add(treeNode.val);
                if(treeNode.left != null){
                    deque.addLast(treeNode.left);
                }
                if(treeNode.right != null){
                    deque.addLast(treeNode.right);
                }
            }
            list.add(l);
        }
        return list;
    }
}
