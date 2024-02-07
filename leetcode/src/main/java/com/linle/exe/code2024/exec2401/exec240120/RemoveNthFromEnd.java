package com.linle.exe.code2024.exec2401.exec240120;

import com.linle.exe.common.ListNode;
import org.junit.Test;

/**
 * @description: 19. 删除链表的倒数第 N 个结点 middle
 * @author: chendeli
 * @date: 2024-01-20 11:27
 */
public class RemoveNthFromEnd {

    /**
     * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
     *
     * 示例 1：
     *
     * 输入：head = [1,2,3,4,5], n = 2
     * 输出：[1,2,3,5]
     * 示例 2：
     *
     * 输入：head = [1], n = 1
     * 输出：[]
     * 示例 3：
     *
     * 输入：head = [1,2], n = 1
     * 输出：[1]
     *
     * 提示：
     *
     * 链表中结点的数目为 sz
     * 1 <= sz <= 30
     * 0 <= Node.val <= 100
     * 1 <= n <= sz
     *
     * 进阶：你能尝试使用一趟扫描实现吗？
     */
    @Test
    public void test(){
        ListNode listNode3 = new ListNode(1);
        ListNode listNode4 = new ListNode(2);
        ListNode listNode5 = new ListNode(3);
        ListNode listNode6 = new ListNode(4);
        ListNode listNode7 = new ListNode(5);
        listNode3.next = listNode4;
        listNode3.next.next = listNode5;
        listNode3.next.next.next = listNode6;
        listNode3.next.next.next.next = listNode7;
        removeNthFromEnd(listNode3,2);

    }


    /**
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode headT = new ListNode();
        headT.next = head;
        ListNode curr = headT;
        ListNode pre = headT;
        while(n-- > 0 ){
            pre = pre.next;
        }
        while(pre != null && pre.next != null){
            curr = curr.next;
            pre = pre.next;
        }
        curr.next = curr.next.next;
        return headT.next;

    }

}
