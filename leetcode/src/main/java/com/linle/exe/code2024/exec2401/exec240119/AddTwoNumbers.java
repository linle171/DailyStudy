package com.linle.exe.code2024.exec2401.exec240119;

import com.linle.exe.common.ListNode;
import org.junit.Test;

import java.text.BreakIterator;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @description: 2. 两数相加 middle
 * @author: chendeli
 * @date: 2024-01-19 21:18
 */
public class AddTwoNumbers {
    /**
     * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
     * <p>
     * 请你将两个数相加，并以相同形式返回一个表示和的链表。
     * <p>
     * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     * <p>
     * 示例 1：
     * <p>
     * 输入：l1 = [2,4,3], l2 = [5,6,4]
     * 输出：[7,0,8]
     * 解释：342 + 465 = 807.
     * 示例 2：
     * <p>
     * 输入：l1 = [0], l2 = [0]
     * 输出：[0]
     * 示例 3：
     * <p>
     * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
     * 输出：[8,9,9,9,0,0,0,1]
     * <p>
     * 提示：
     * <p>
     * 每个链表中的节点数在范围 [1, 100] 内
     * 0 <= Node.val <= 9
     * 题目数据保证列表表示的数字不含前导零
     */
    @Test
    public void test() {
        ListNode listNode = new ListNode(9);
        ListNode listNode1 = new ListNode(9);
        ListNode listNode2 = new ListNode(9);
        ListNode listNode9 = new ListNode(9);
        listNode.next = listNode1;
        listNode.next.next = listNode2;
        listNode.next.next.next = listNode9;

        ListNode listNode3 = new ListNode(9);
        ListNode listNode4 = new ListNode(9);
        ListNode listNode5 = new ListNode(9);
        ListNode listNode6 = new ListNode(9);
        ListNode listNode7 = new ListNode(9);
        ListNode listNode8 = new ListNode(9);
        ListNode listNode10 = new ListNode(9);
        listNode3.next = listNode4;
        listNode3.next.next = listNode5;
        listNode3.next.next.next = listNode6;
        listNode3.next.next.next.next = listNode7;
        listNode3.next.next.next.next.next = listNode8;
        listNode3.next.next.next.next.next.next = listNode10;
        addTwoNumbers1(listNode, listNode3);
    }

    /**
     * 原始的方法 超出内存限制是
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l = new ListNode();
        Deque<Integer> deque1 = new ArrayDeque<>();
        Deque<Integer> deque2 = new ArrayDeque<>();
        while (l1 != null) {
            deque1.add(l1.val);
        }
        while (l2 != null) {
            deque2.add(l2.val);
        }
        boolean plus = false;
        while (!deque1.isEmpty() && !deque2.isEmpty()) {
            ListNode temp = new ListNode();
            int value = deque1.pop() + deque2.pop() + (plus ? 1 : 0);
            if (value > 9) {
                temp.val = value - 10;
                plus = true;
            } else {
                temp.val = value;
                plus = false;
            }
            temp.next = l;
            l = temp;
        }

        if (deque1 != null) {
            while (!deque1.isEmpty()) {
                ListNode temp = new ListNode();
                int value = deque1.pop() + (plus ? 1 : 0);
                if (value > 9) {
                    temp.val = value - 10;
                    plus = true;
                } else {
                    temp.val = value;
                    plus = false;
                }
                temp.next = l;
                l = temp;
            }
        }

        if (deque2 != null) {
            while (!deque2.isEmpty()) {
                ListNode temp = new ListNode();
                int value = deque2.pop() + (plus ? 1 : 0);
                if (value > 9) {
                    temp.val = value - 10;
                    plus = true;
                } else {
                    temp.val = value;
                    plus = false;
                }
                temp.next = l;
                l = temp;
            }
        }
        return l;
    }

    /**
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        //分别将连个链表反转
        ListNode Tl1 = l1;
        ListNode Tl2 = l2;
        ListNode result = Tl1;
        Boolean isPlus = false;
        while (Tl1 != null && Tl2 != null) {
            int value = Tl2.val + Tl1.val + (isPlus ? 1 : 0);
            if (value > 9) {
                Tl1.val = value - 10;
                isPlus = true;
            } else {
                Tl1.val = value;
                isPlus = false;
            }
            if (Tl1.next == null) {
                if (Tl2.next != null) {
                    Tl1.next = Tl2.next;
                }
                break;
            }
            if(Tl2.next == null){
                break;
            }
            Tl1 = Tl1.next;
            Tl2 = Tl2.next;
        }
        while (isPlus && Tl1.next != null) {
            int value = Tl1.next.val + (isPlus ? 1 : 0);
            if (value > 9) {
                Tl1.next.val = value - 10;
                isPlus = true;
            } else {
                Tl1.next.val = value;
                isPlus = false;
            }
            Tl1 = Tl1.next;
            if(Tl1.next == null){
                break;
            }
        }
        if (isPlus) {
            Tl1.next = new ListNode(1);
        }
        return result;

    }

    private ListNode reverse(ListNode l1) {
        ListNode pre = null;
        ListNode curr = l1;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
        }
        return pre;
    }
}
