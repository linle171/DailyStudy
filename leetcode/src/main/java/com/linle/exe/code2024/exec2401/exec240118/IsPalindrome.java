package com.linle.exe.code2024.exec2401.exec240118;

import com.linle.exe.common.ListNode;
import org.apache.el.parser.AstFalse;
import org.junit.Test;

/**
 * @description: 234. 回文链表 simple
 * @author: chendeli
 * @date: 2024-01-18 22:53
 */
public class IsPalindrome {
    /**
     * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
     * <p>
     * 示例 1：
     * <p>
     * 输入：head = [1,2,2,1]
     * 输出：true
     * 示例 2：
     * <p>
     * 输入：head = [1,2]
     * 输出：false
     * <p>
     * 提示：
     * <p>
     * 链表中节点数目在范围[1, 105] 内
     * 0 <= Node.val <= 9
     * <p>
     * 进阶：你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
     */
    @Test
    public void test() {
    }


    /**
     * 解题思路：
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        ListNode q = head;
        ListNode queryMidValue = queryMidValue(head);
        ListNode rome = rome(queryMidValue.next);

        ListNode  p = rome;
        boolean result = true;
        while(result && p != null){
            if(p.val != q.val){
                result =  false;
            }
            p = p.next;
            q = q.next;
        }
        queryMidValue = rome(rome);
        return result;
    }

    private ListNode rome(ListNode preHalf) {
        ListNode pre = null;
        ListNode curr = preHalf;
        while(curr !=null){
            ListNode temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
        }
        return pre;
    }

    private ListNode queryMidValue(ListNode head) {
        ListNode low = head;
        ListNode hige = head;
        while(hige.next != null && hige.next.next != null){
            low = low.next;
            hige = hige.next.next;
        }
        return low;
    }
}
