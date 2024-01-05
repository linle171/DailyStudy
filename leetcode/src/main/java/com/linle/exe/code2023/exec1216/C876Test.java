package com.linle.exe.code2023.exec1216;

import org.junit.Test;

/**
 * @author chendeli
 * @Description: 链表的中间结点
 * @date 2022/12/16 9:45
 */
public class C876Test {

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
     * 给定一个头结点为 head 的非空单链表，返回链表的中间结点。
     * <p>
     * 如果有两个中间结点，则返回第二个中间结点。
     * <p>
     * 给定链表的结点数介于 1 和 100 之间。
     */
    @Test
    public void test876() {
        ListNode listNode = new ListNode(1, null);
        if (listNode.next == null) {
            return;
        }
        ListNode preNode = listNode, subNode = listNode;
        while (listNode.next != null) {
            preNode = preNode.next;
            if (subNode.next != null) {
                subNode = subNode.next.next;
            } else {
                subNode = null;
            }
        }
        return;


    }
}
