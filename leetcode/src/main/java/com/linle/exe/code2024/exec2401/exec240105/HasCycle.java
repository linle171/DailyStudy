package com.linle.exe.code2024.exec240105;

import java.util.List;

/**
 * @description: 141题. 环形链表  simple
 * @author: chendeli
 * @date: 2024-01-05 10:33
 */
public class HasCycle {
    /**
     * 给你一个链表的头节点 head ，判断链表中是否有环。
     * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。
     * 如果链表中存在环 ，则返回 true 。 否则，返回 false 。
     *
     * 提示：
     * 链表中节点的数目范围是 [0, 104]
     * -10^5 <= Node.val <= 10^5
     * pos 为 -1 或者链表中的一个 有效索引 。
     *
     * 进阶：你能用 O(1)（即，常量）内存解决此问题吗？
     */
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * 使用快慢指针，若是存在环，总会相遇
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if(head == null){
            return false;
        }
        ListNode pre = head;
        ListNode tail = head;
        while( (tail = tail.next) != null && pre != tail  ){
            pre = pre.next;
            if(tail.next != null) {
                tail = tail.next;
            }
        }
        if(tail == null){
            return false;
        }
        return true;
    }
}
