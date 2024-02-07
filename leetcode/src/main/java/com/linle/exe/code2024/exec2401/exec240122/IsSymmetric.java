package com.linle.exe.code2024.exec2401.exec240122;

import com.linle.exe.common.TreeNode;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @description: 101. 对称二叉树 simple
 * @author: chendeli
 * @date: 2024-01-22 20:45
 */
public class IsSymmetric {
    /**
     * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
     * <p>
     * 示例 1：
     * <p>
     * 输入：root = [1,2,2,3,4,4,3]
     * 输出：true
     * 示例 2：
     * <p>
     * 输入：root = [1,2,2,null,3,null,3]
     * 输出：false
     * <p>
     * 提示：
     * <p>
     * 树中节点数目在范围 [1, 1000] 内
     * -100 <= Node.val <= 100
     * <p>
     * 进阶：你可以运用递归和迭代两种方法解决这个问题吗？
     */
    @Test
    public void test() {
    }

    /**
     * 解题思路
     * 1、递归
     *
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        return symmetric(root.left, root.right);
    }

    private boolean symmetric(TreeNode left, TreeNode right) {
        if (left == null || right == null) {
            if (left == right) {
                return true;
            }
            return false;
        }
        if(left.val == right.val) {
            return symmetric(left.left, right.right) && symmetric(left.right, right.left);
        }
        return false;
    }

    /**
     * 解题思路
     * 2、迭代
     * @param root
     * @return
     */
    public boolean isSymmetric1(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        list.add(root.left);
        list.add(root.right);
        while (!list.isEmpty()){
            int size= list.size();
            int l = 0,r = list.size()-1;
            while(l<r){
                TreeNode left = list.get(l);
                TreeNode right = list.get(r);
                if (left == null || right == null) {
                    if (left != right) {
                        return false;
                    }
                }
                if(left.val != right.val){
                    return false;
                }
                l++;
                r--;
            }
            int j = 0;
            while(j < size){
                TreeNode remove = list.remove(j);
                if(remove == null){
                    j++;
                    continue;
                }
                list.add(remove.left);
                list.add(remove.right);
                j++;
            }
        }
        return true;
    }
}
