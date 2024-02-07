package com.linle.exe.code2024.exec2401.exec240125;

import com.linle.exe.common.TreeNode;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 105. 从前序与中序遍历序列构造二叉树 middle
 * @author: chendeli
 * @date: 2024-01-25 09:30
 */
public class BuildTree {
    /**
     * 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
     * <p>
     * 示例 1:
     * <p>
     * 输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
     * 输出: [3,9,20,null,null,15,7]
     * 示例 2:
     * <p>
     * 输入: preorder = [-1], inorder = [-1]
     * 输出: [-1]
     * <p>
     * 提示:
     * <p>
     * 1 <= preorder.length <= 3000
     * inorder.length == preorder.length
     * -3000 <= preorder[i], inorder[i] <= 3000
     * preorder 和 inorder 均 无重复 元素
     * inorder 均出现在 preorder
     * preorder 保证 为二叉树的前序遍历序列
     * inorder 保证 为二叉树的中序遍历序列
     */
    @Test
    public void test() {
//        int[] l1 = new int[]{3, 9, 20, 15, 7};
//        int[] l2 = new int[]{9, 3, 15, 20, 7};
        int[] l1 = new int[]{1,2};
        int[] l2 = new int[]{2,1};
        buildTree(l1, l2);
    }

    /**
     * 解题思路：
     *
     * @param preorder
     * @param inorder
     * @return
     */
    Map<Integer, Integer> map;
    int index = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = new TreeNode(3001);
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        build(preorder, 0, inorder.length - 1, root);
        //去除为空节点

        removeNullNode(root);
        return root;
    }

    private void removeNullNode(TreeNode root) {
        if(root == null){
            return;
        }
        if(root.left != null && root.left.val == 3001){
            root.left = null;
        }
        if(root.right != null && root.right.val == 3001){
            root.right = null;
        }
        removeNullNode(root.left);
        removeNullNode(root.right);
    }

    private void build(int[] preorder, int l, int r, TreeNode root) {
        if (index > preorder.length - 1) {
            return;
        }
        Integer temp = map.get(preorder[index]);
        if (l > r || temp > r || temp < l) {
            return;
        }
        root.val = preorder[index++];
        root.left = new TreeNode(3001);
        build(preorder, l, temp - 1, root.left);
        root.right = new TreeNode(3001);
        build(preorder, temp + 1, r, root.right);
    }

    /*********************************************************/
    private int[] preorder;
    private HashMap<Integer, Integer> dic = new HashMap<>(); //方便查找元素位置

    public TreeNode buildTree1(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        for(int i = 0; i < inorder.length; i++) {
            dic.put(inorder[i], i);
        }

        return recur(0, 0, inorder.length - 1);
    }

    // root：先序遍历root位置；left：中序遍历左子树；right：中序遍历右子树
    private TreeNode recur(int root, int left, int right) {
        // 递归终止
        if(left > right) {
            return null;
        }

        TreeNode node = new TreeNode(preorder[root]);
        int i = dic.get(preorder[root]);
        node.left = recur(root+1, left, i-1);
        node.right = recur(i + root - left + 1, i + 1, right);

        return node;
    }
}
