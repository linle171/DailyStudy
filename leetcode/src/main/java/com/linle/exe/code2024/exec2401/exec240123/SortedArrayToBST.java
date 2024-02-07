package com.linle.exe.code2024.exec2401.exec240123;

import com.linle.exe.common.TreeNode;
import org.junit.Test;

/**
 * @description: 108. 将有序数组转换为二叉搜索树 simple
 * @author: chendeli
 * @date: 2024-01-23 22:37
 */
public class SortedArrayToBST {
    /**
     * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
     *
     * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
     *
     * 示例 1：
     *
     * 输入：nums = [-10,-3,0,5,9]
     * 输出：[0,-3,9,-10,null,5]
     * 解释：[0,-10,5,null,-3,null,9] 也将被视为正确答案：
     *
     * 示例 2：
     *
     * 输入：nums = [1,3]
     * 输出：[3,1]
     * 解释：[1,null,3] 和 [3,1] 都是高度平衡二叉搜索树。
     *
     * 提示：
     *
     * 1 <= nums.length <= 104
     * -104 <= nums[i] <= 104
     * nums 按 严格递增 顺序排列
     */
    @Test
    public void test(){

        sortedArrayToBST(new int[]{1,2,3,4});
    }

    /**
     *
     * 解题思路：
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        int len = nums.length;
        int mid = len >> 1;
        TreeNode root = new TreeNode(nums[mid]);
        bst(root,0,mid-1,nums);
        bst(root,mid+1,len-1,nums);
        return root;
    }

    private void bst(TreeNode root, int l, int r, int[] nums) {
        if(l > r){
            return;
        }
        int mid = l+((r-l)>>1);
        TreeNode temp;
        if(root.val > nums[mid]) {
            temp = new TreeNode( nums[mid]);
            root.left = temp;
        }else {
            temp = new TreeNode(nums[mid]);
            root.right = temp;
        }
        bst(temp,l,mid-1,nums);
        bst(temp,mid+1,r,nums);
    }
}
