package com.linle.exe.code2024.exec2401.exec240120;

import com.linle.exe.common.ListNode;
import com.linle.exe.common.Node;
import org.junit.Test;

import java.util.*;

/**
 * @description: 138. 随机链表的复制 middle
 * @author: chendeli
 * @date: 2024-01-20 15:22
 */
public class CopyRandomList {
    /**
     * 给你一个长度为 n 的链表，每个节点包含一个额外增加的随机指针 random ，该指针可以指向链表中的任何节点或空节点。
     * <p>
     * 构造这个链表的 深拷贝。 深拷贝应该正好由 n 个 全新 节点组成，其中每个新节点的值都设为其对应的原节点的值。新节点的 next 指针和 random 指针也都应指向复制链表中的新节点，并使原链表和复制链表中的这些指针能够表示相同的链表状态。复制链表中的指针都不应指向原链表中的节点 。
     * <p>
     * 例如，如果原链表中有 X 和 Y 两个节点，其中 X.random --> Y 。那么在复制链表中对应的两个节点 x 和 y ，同样有 x.random --> y 。
     * <p>
     * 返回复制链表的头节点。
     * <p>
     * 用一个由 n 个节点组成的链表来表示输入/输出中的链表。每个节点用一个 [val, random_index] 表示：
     * <p>
     * val：一个表示 Node.val 的整数。
     * random_index：随机指针指向的节点索引（范围从 0 到 n-1）；如果不指向任何节点，则为  null 。
     * 你的代码 只 接受原链表的头节点 head 作为传入参数。
     * <p>
     * 示例 1：
     * <p>
     * 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
     * 输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
     * 示例 2：
     * <p>
     * 输入：head = [[1,1],[2,1]]
     * 输出：[[1,1],[2,1]]
     * 示例 3：
     * <p>
     * 输入：head = [[3,null],[3,0],[3,null]]
     * 输出：[[3,null],[3,0],[3,null]]
     * <p>
     * 提示：
     * <p>
     * 0 <= n <= 1000
     * -104 <= Node.val <= 104
     * Node.random 为 null 或指向链表中的节点。
     */
    @Test
    public void test() {
        Node listNode3 = new Node(1);
        Node listNode4 = new Node(2);
        Node listNode5 = new Node(3);
        Node listNode6 = new Node(4);
        Node listNode7 = new Node(5);
        listNode4.random = listNode3;
        listNode3.next = listNode4;
        listNode5.random = listNode7;
        listNode3.next.next = listNode5;
        listNode6.random = listNode5;
        listNode3.next.next.next = listNode6;
        listNode7.random = listNode3;
        listNode3.next.next.next.next = listNode7;
        copyRandomList(listNode3);
    }


    /**
     * @param head
     * @return
     */
    public Node copyRandomList(Node head) {
        Node temp = head;
        Map<Node, Integer> headP = new HashMap<>();
        List<Node> headT = new ArrayList<>();
        int i = 0;
        while (temp != null) {
            headP.put(temp, i);
            Node node = new Node(temp.val);
            if (!headT.isEmpty()) {
                Node preNode = headT.get(headT.size() - 1);
                preNode.next = node;
            }
            headT.add(node);
            temp = temp.next;
            i++;
        }
        temp = head;
        for (int j = 0; j < headT.size(); j++) {
            Node random = temp.random;
            if (random != null) {
                Integer k = headP.get(random);
                Node node = headT.get(j);
                node.random = headT.get(k);
            }
            temp = temp.next;
        }
        return headT.isEmpty() ? null : headT.get(0);
    }

    /**
     * 拆分节点 就是新的节点插入到旧节点 然后第一次遍历赋值random
     * 1、先取旧节点的random 那么新节点的random就在旧节点的random.next
     * @param head
     * @return
     */
    public Node copyRandomList1(Node head) {
        if (head == null) {
            return null;
        }
        for (Node node = head; node != null; node = node.next.next) {
            Node nodeNew = new Node(node.val);
            nodeNew.next = node.next;
            node.next = nodeNew;
        }
        for (Node node = head; node != null; node = node.next.next) {
            Node nodeNew = node.next;
            nodeNew.random = (node.random != null) ? node.random.next : null;
        }
        Node headNew = head.next;
        for (Node node = head; node != null; node = node.next) {
            Node nodeNew = node.next;
            node.next = node.next.next;
            nodeNew.next = (nodeNew.next != null) ? nodeNew.next.next : null;
        }
        return headNew;

    }
}
