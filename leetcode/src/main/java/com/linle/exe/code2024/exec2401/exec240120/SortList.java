package com.linle.exe.code2024.exec2401.exec240120;

import com.linle.exe.common.ListNode;
import org.junit.Test;

/**
 * @description: 148. 排序链表  middle
 * @author: chendeli
 * @date: 2024-01-20 17:05
 */
public class SortList {
    /**
     * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
     * <p>
     * 示例 1：
     * <p>
     * 输入：head = [4,2,1,3]
     * 输出：[1,2,3,4]
     * 示例 2：
     * <p>
     * 输入：head = [-1,5,3,4,0]
     * 输出：[-1,0,3,4,5]
     * 示例 3：
     * <p>
     * 输入：head = []
     * 输出：[]
     * <p>
     * 提示：
     * <p>
     * 链表中节点的数目在范围 [0, 5 * 104] 内
     * -105 <= Node.val <= 105
     * <p>
     * 进阶：你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
     */
    @Test
    public void test() {
    }

    /**
     * 解题思路：
     *
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        ListNode h = new ListNode();
        h.next = head;

        ListNode curr = head;

        int length = 0;
        while (curr != null){
            curr = curr.next;
            length++;
        }

        for (int subLength = 1; subLength < length ; subLength <<= 1) {
            ListNode pre = h;curr = head;
            while(curr != null) {
                ListNode head1 = curr;
                for (int i = 1; i < subLength && curr.next != null; i++) {
                    curr = curr.next;
                }
                //获取head1的链表
                ListNode head2 = curr.next;
                curr.next = null;
                curr = head2;
                for (int i = 1; i < subLength && curr != null && curr.next != null; i++) {
                    curr = curr.next;
                }
                ListNode next = null;
                if(curr != null){
                    next = curr.next ;
                    curr.next = null;
                }
                ListNode merge = merge(head1, head2);
                pre.next = merge;
                while(pre != null && pre.next != null){
                    pre = pre.next;
                }
                curr = next;
            }
        }
        return h.next;
    }


    ListNode merge(ListNode l1,ListNode l2){
        ListNode listNode = new ListNode();
        ListNode head = listNode;
        while(l1 != null && l2 !=null){
            if(l1.val> l2.val){
                head.next = l2;
                l2 = l2.next;
            }else {
                head.next = l1;
                l1 = l1.next;
            }
            head = head.next;
        }
        head.next = l1 !=null? l1:l2;
        return listNode.next;
    }
}
