package com.linle.exe.code2023.exec1216;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @author chendeli
 * @Description: 删除链表的倒数第 N 个结点
 * @date 2022/12/16 10:14
 */
public class C19Test {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * 题目：
     * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
     * <p>
     * 提示：
     * 链表中结点的数目为 sz
     * 1 <= sz <= 30
     * 0 <= Node.val <= 100
     * 1 <= n <= sz
     */
    @Test
    public void test19() {
        ListNode head = new ListNode(1, null);
        int n = 1;
        ListNode target = new ListNode(0,head);
        ListNode preNode = head,subNode = target;
        for(int i = 1;i<=n;i++){
            preNode = preNode.next;
        }

        while(preNode != null){
            subNode = subNode.next;
            preNode = preNode.next;
        }

        subNode.next = subNode.next.next;


    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ArrayList<String> list = new ArrayList<>();
        return null;
    }
}
