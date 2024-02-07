package com.linle.exe.code2024.exec2401.exec240119;

import com.linle.exe.common.ListNode;
import org.junit.Test;
import org.w3c.dom.ls.LSException;

/**
 * @description: 21. 合并两个有序链表 simple
 * @author: chendeli
 * @date: 2024-01-19 10:49
 */
public class MergeTwoLists {
    /**
     * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     *
     * 示例 1：
     *
     * 输入：l1 = [1,2,4], l2 = [1,3,4]
     * 输出：[1,1,2,3,4,4]
     * 示例 2：
     *
     * 输入：l1 = [], l2 = []
     * 输出：[]
     * 示例 3：
     *
     * 输入：l1 = [], l2 = [0]
     * 输出：[0]
     *
     * 提示：
     *
     * 两个链表的节点数目范围是 [0, 50]
     * -100 <= Node.val <= 100
     * l1 和 l2 均按 非递减顺序 排列
     */
    @Test
    public void  test(){
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2= new ListNode(3);
        listNode.next = listNode1;
        listNode.next.next = listNode2;

        ListNode listNode3 = new ListNode(1);
        ListNode listNode4 = new ListNode(1);
        ListNode listNode5 = new ListNode(4);
        listNode3.next = listNode4;
        listNode3.next.next = listNode5;
        mergeTwoLists(listNode, listNode3);
    }

    /**
     *
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result =  new ListNode();
        ListNode pre= result;
        while (list1 != null && list2 != null){
            if(list1.val > list2.val){
                pre.next = list2;
                pre = pre.next;
                list2 = list2.next;
            }else {
                pre.next = list1;
                pre = pre.next;
                list1 = list1.next;
            }
        }

        pre.next  = list1 != null ? list1 :list2;
        return result.next;
    }
}
