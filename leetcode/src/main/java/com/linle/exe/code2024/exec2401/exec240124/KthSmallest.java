package com.linle.exe.code2024.exec2401.exec240124;

import com.linle.exe.common.TreeNode;
import org.junit.Test;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * @description: 230. 二叉搜索树中第K小的元素 middle
 * @author: chendeli
 * @date: 2024-01-24 17:46
 */
public class KthSmallest {
    /**
     * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
     *
     * 示例 1：
     *
     * 输入：root = [3,1,4,null,2], k = 1
     * 输出：1
     * 示例 2：
     *
     * 输入：root = [5,3,6,2,4,null,null,1], k = 3
     * 输出：3
     *
     * 提示：
     *
     * 树中的节点数为 n 。
     * 1 <= k <= n <= 104
     * 0 <= Node.val <= 104
     *
     * 进阶：如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化算法？
     */
    @Test
    public void test(){}

    /**
     *
     * 解题思路：中序查找
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest(TreeNode root, int k) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        kth(root,treeSet);
        Iterator<Integer> iterator = treeSet.iterator();
        while(--k>0 && iterator.hasNext()){
            iterator.next();
        }
        return  iterator.next();
    }

    private void kth(TreeNode root, TreeSet<Integer> treeSet) {
        if(root == null){
            return;
        }
        kth(root.left,treeSet);
        treeSet.add(root.val);

        kth(root.right,treeSet);
    }
    int temp ;
    int value = 0;
    public int kthSmallest1(TreeNode root, int k) {
        temp = k;
        kth1(root);
        return  value;
    }

    private void kth1(TreeNode root) {
        if(root == null){
            return;
        }
        kth1(root.left);
        if(temp-- > 0){
            value = root.val;
            return;
        }
        kth1(root.right);
    }
}
