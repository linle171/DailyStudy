package com.linle.exe.code2024.exec2401.exec240120;

import com.linle.exe.common.ListNode;
import org.junit.Test;

import java.util.List;

/**
 * @description: 25. K 个一组翻转链表 difficult
 * @author: chendeli
 * @date: 2024-01-20 12:40
 */
public class ReverseKGroup {
    /**
     * 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
     * <p>
     * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
     * <p>
     * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
     * <p>
     * 示例 1：
     * <p>
     * 输入：head = [1,2,3,4,5], k = 2
     * 输出：[2,1,4,3,5]
     * 示例 2：
     * <p>
     * 输入：head = [1,2,3,4,5], k = 3
     * 输出：[3,2,1,4,5]
     * <p>
     * 提示：
     * 链表中的节点数目为 n
     * 1 <= k <= n <= 5000
     * 0 <= Node.val <= 1000
     * <p>
     * 进阶：你可以设计一个只用 O(1) 额外内存空间的算法解决此问题吗？
     */
    @Test
    public void test() {
        ListNode listNode3 = new ListNode(1);
        ListNode listNode4 = new ListNode(2);
        ListNode listNode5 = new ListNode(3);
        ListNode listNode6 = new ListNode(4);
        ListNode listNode7 = new ListNode(5);
        listNode3.next = listNode4;
        listNode3.next.next = listNode5;
        listNode3.next.next.next = listNode6;
        listNode3.next.next.next.next = listNode7;
        reverseKGroup(listNode3,2);
    }

    /**
     *
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode headT = new ListNode();
        headT.next = head;
        ListNode pre = headT;
        ListNode suf = headT;
        while(true) {
            int j = k;
            while (j-- > 0 && suf != null) {
                suf = suf.next;
            }
            if(suf != null){
                ListNode h = pre.next;
                ListNode curr = suf.next;
                int i = k;
                while(i-->0 ){
                    ListNode next = h.next;
                    h.next = curr;
                    curr = h;
                    h = next;
                }
                i = k;
                pre.next = curr;
                pre = pre.next;
                while (--i>0){
                    pre = pre.next;
                    suf = suf.next;
                }
            }else {
                break;
            }
        }
        return headT.next;
    }
}
