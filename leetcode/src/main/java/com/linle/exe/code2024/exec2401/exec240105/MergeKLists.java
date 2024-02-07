package com.linle.exe.code2024.exec2401.exec240105;

import com.linle.exe.common.ListNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 23题. 合并 K 个升序链表  difficult
 * @author: chendeli
 * @date: 2024-01-05 13:36
 */
public class MergeKLists {
    /**
     * 给你一个链表数组，每个链表都已经按升序排列。
     *
     * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
     *
     * 示例 1：
     *
     * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
     * 输出：[1,1,2,3,4,4,5,6]
     * 解释：链表数组如下：
     * [
     *   1->4->5,
     *   1->3->4,
     *   2->6
     * ]
     * 将它们合并到一个有序链表中得到。
     * 1->1->2->3->4->4->5->6
     * 示例 2：
     *
     * 输入：lists = []
     * 输出：[]
     * 示例 3：
     *
     * 输入：lists = [[]]
     * 输出：[]
     *
     * 提示：
     *
     * k == lists.length
     * 0 <= k <= 10^4
     * 0 <= lists[i].length <= 500
     * -10^4 <= lists[i][j] <= 10^4
     * lists[i] 按 升序 排列
     * lists[i].length 的总和不超过 10^4
     */


    /**
     * 归并排序
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length;
        if(len == 0){
            return null;
        }
        if(len == 1){
            return lists[0];
        }
        ListNode pre = mergeKLists(Arrays.copyOfRange(lists, 0, len >> 1));
        ListNode tail = mergeKLists(Arrays.copyOfRange(lists, (len >> 1), len));
        return merge(pre,tail);
    }

    private ListNode merge(ListNode pre,ListNode tail) {
        if(pre == null || tail == null){
            return pre == null ? tail:pre;
        }
        ListNode target = new ListNode(0);
        ListNode temp = target;
        while(pre != null && tail != null){
            if(pre.val < tail.val ){
                temp.next = pre;
                pre = pre.next;
            }else {
                temp.next = tail;
                tail = tail.next;
            }
            temp = temp.next;
        }

        temp.next = pre != null ? pre:tail;

        return target.next;
    }

    /**
     * [[1,4,5],[1,3,4],[2,6]]
     */
    @Test
    public void test(){
        List<ListNode> li = new ArrayList<>();
//        ListNode listNode = new ListNode(1);
//        listNode.next = new ListNode(4);
//        listNode.next.next = new ListNode(5);
//
//        ListNode listNode1 = new ListNode(1);
//        listNode1.next = new ListNode(2);
//        listNode1.next.next = new ListNode(4);
//
//        ListNode listNode2 = new ListNode(2);
//        listNode2.next = new ListNode(6);
//

//        li.add(listNode);
//        li.add(listNode1);
//        li.add(listNode2);
        ListNode listNode3 = mergeKLists(li.toArray(new ListNode[]{}));
        System.out.println(listNode3);

    }
}
