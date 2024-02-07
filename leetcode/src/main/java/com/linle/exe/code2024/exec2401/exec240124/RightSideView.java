package com.linle.exe.code2024.exec2401.exec240124;

import com.linle.exe.common.TreeNode;
import org.checkerframework.checker.units.qual.A;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @description: 199. 二叉树的右视图 middle
 * @author: chendeli
 * @date: 2024-01-24 18:08
 */
public class RightSideView {
    /**
     * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
     *
     * 示例 1:
     *
     * 输入: [1,2,3,null,5,null,4]
     * 输出: [1,3,4]
     * 示例 2:
     *
     * 输入: [1,null,3]
     * 输出: [1,3]
     * 示例 3:
     *
     * 输入: []
     * 输出: []
     *
     * 提示:
     *
     * 二叉树的节点个数的范围是 [0,100]
     * -100 <= Node.val <= 100
     */
    @Test
    public void test(){
        TreeNode treeNode = new TreeNode(1);
        treeNode.right = new TreeNode(2);
        rightSideView(treeNode);
    }

    /**
     *
     * 解题思路：bfs
     *
     * @param root
     * @return
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null){
            return  list;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        while(!deque.isEmpty()){
            int size = deque.size();
            Boolean isFirst = true;
            while(size-->0){
                TreeNode pop = deque.pollFirst();
                if(isFirst) {
                    isFirst = !isFirst;
                    list.add(pop.val);
                }
                if(pop.right != null){
                    deque.addLast(pop.right);
                }
                if(pop.left != null){
                    deque.addLast(pop.left);
                }
            }
        }
        return list;
    }

    List<Integer> res = new ArrayList<>();

    public List<Integer> rightSideView1(TreeNode root) {
        dfs(root, 0); // 从根节点开始访问，根节点深度是0
        return res;
    }

    private void dfs(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        // 先访问 当前节点，再递归地访问 右子树 和 左子树。
        if (depth == res.size()) {   // 如果当前节点所在深度还没有出现在res里，说明在该深度下当前节点是第一个被访问的节点，因此将当前节点加入res中。
            res.add(root.val);
        }
        depth++;
        dfs(root.right, depth);
        dfs(root.left, depth);
    }


}
