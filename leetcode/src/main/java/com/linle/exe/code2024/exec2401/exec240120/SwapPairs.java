package com.linle.exe.code2024.exec2401.exec240120;

import com.linle.exe.common.ListNode;
import org.junit.Test;

/**
 * @description: 24. 两两交换链表中的节点 middle
 * @author: chendeli
 * @date: 2024-01-20 11:44
 */
public class SwapPairs {
    /**
     * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
     *
     * 示例 1：
     *
     * 输入：head = [1,2,3,4]
     * 输出：[2,1,4,3]
     * 示例 2：
     *
     * 输入：head = []
     * 输出：[]
     * 示例 3：
     *
     * 输入：head = [1]
     * 输出：[1]
     *
     * 提示：
     *
     * 链表中节点的数目在范围 [0, 100] 内
     * 0 <= Node.val <= 100
     */
    @Test
    public  void test(){
        ListNode listNode3 = new ListNode(1);
        ListNode listNode4 = new ListNode(2);
        ListNode listNode5 = new ListNode(3);
        ListNode listNode6 = new ListNode(4);
        ListNode listNode7 = new ListNode(5);
        listNode3.next = listNode4;
        listNode3.next.next = listNode5;
        listNode3.next.next.next = listNode6;
        listNode3.next.next.next.next = listNode7;
        swapPairs(listNode3);
    }

    /**
     * 不明白的可以画图
     *
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        ListNode headT = new ListNode();
        headT.next = head;
        ListNode pre = headT;
        while(pre.next != null && pre.next.next != null){
            ListNode temp = pre.next;
            pre.next = pre.next.next;
            pre = pre.next;
            temp.next = pre.next;
            pre.next = temp;
            pre = pre.next;
        }
        return headT.next;
    }
}
