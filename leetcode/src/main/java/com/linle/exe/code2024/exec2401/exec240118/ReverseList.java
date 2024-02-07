package com.linle.exe.code2024.exec2401.exec240118;

import com.linle.exe.common.ListNode;
import org.junit.Test;

/**
 * @description: 206. 反转链表 simple
 * @author: chendeli
 * @date: 2024-01-18 21:33
 */
public class ReverseList {
    /**
     * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
     * <p>
     * 示例 1：
     * <p>
     * 输入：head = [1,2,3,4,5]
     * 输出：[5,4,3,2,1]
     * 示例 2：
     * <p>
     * 输入：head = [1,2]
     * 输出：[2,1]
     * 示例 3：
     * <p>
     * 输入：head = []
     * 输出：[]
     * <p>
     * 提示：
     * <p>
     * 链表中节点的数目范围是 [0, 5000]
     * -5000 <= Node.val <= 5000
     * <p>
     * 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？
     */
    @Test
    public void test() {
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2= new ListNode(3);
        ListNode listNode3 = new ListNode(4);
        ListNode listNode4 = new ListNode(5);
        listNode.next = listNode1;
        listNode.next.next = listNode2;
        listNode.next.next.next = listNode3;
        listNode.next.next.next.next = listNode4;
        reverseList(listNode);
    }



    /**
     *
     * @param head
     * @return
     */
    ListNode headT = new ListNode();
    ListNode pre = new ListNode();
    public ListNode reverseList(ListNode head) {
        reverse(head);
        return pre;
    }

    private void reverse(ListNode head) {
        if(head == null ){
            return;
        }
        if(head.next == null){
            headT = head;
            pre = head;
            return;
        }
        reverse(head.next);
        head.next = null;
        headT.next = head;
        headT = headT.next;
    }


}
