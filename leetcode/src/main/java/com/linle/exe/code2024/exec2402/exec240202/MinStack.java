package com.linle.exe.code2024.exec2402.exec240202;

import org.junit.Test;

import java.util.*;

/**
 * @description: 155. 最小栈 middle
 * @author: chendeli
 * @date: 2024-02-02 11:33
 */
public class MinStack {
    /**
     * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
     * <p>
     * 实现 MinStack 类:
     * <p>
     * MinStack() 初始化堆栈对象。
     * void push(int val) 将元素val推入堆栈。
     * void pop() 删除堆栈顶部的元素。2
     * int top() 获取堆栈顶部的元素。
     * int getMin() 获取堆栈中的最小元素。
     * <p>
     * 示例 1:
     * <p>
     * 输入：
     * ["MinStack","push","push","push","getMin","pop","top","getMin"]
     * [[],[-2],[0],[-3],[],[],[],[]]
     * <p>
     * 输出：
     * [null,null,null,null,-3,null,0,-2]
     * <p>
     * 解释：
     * MinStack minStack = new MinStack();
     * minStack.push(-2);
     * minStack.push(0);
     * minStack.push(-3);
     * minStack.getMin();   --> 返回 -3.
     * minStack.pop();
     * minStack.top();      --> 返回 0.
     * minStack.getMin();   --> 返回 -2.
     * <p>
     * 提示：
     * <p>
     * -231 <= val <= 231 - 1
     * pop、top 和 getMin 操作总是在 非空栈 上调用
     * push, pop, top, and getMin最多被调用 3 * 104 次
     */
    @Test
    public void test() {
        MinStack minStack = new MinStack();
        minStack.push(512);
        minStack.push(-1024);
        minStack.push(-1024);
        minStack.push(512);
        minStack.pop();
        int top = minStack.getMin();
        minStack.pop();
        int top1 = minStack.getMin();
        minStack.pop();
        int top2 = minStack.getMin();
        int min = minStack.getMin();
    }

    Deque<Integer> origin;
    Deque<Integer> sortDeque;

    public MinStack() {
        origin = new LinkedList<>();
        sortDeque = new LinkedList<>();
    }

    public void push(int val) {
        if (origin.isEmpty()) {
            origin.push(val);
            sortDeque.push(val);
            return;
        }
        origin.push(val);
        Integer first = sortDeque.peek();
        if (first >= val) {
            sortDeque.push(val);
        }
    }

    public void pop() {
        if (origin.isEmpty()) {
            return;
        }
        Integer first = origin.pop();
        if (Objects.equals(sortDeque.peek(), first)) {
            sortDeque.pop();
        }
    }

    public int top() {
        return origin.isEmpty() ? 0 : origin.peek();
    }

    public int getMin() {
        return sortDeque.isEmpty() ? 0 : sortDeque.peek();
    }


    Node head;


    public void push1(int val) {
        Node n = new Node(val, head);
        if (head == null) {
            n.min = val;
        } else {
            n.min = getMin1();
        }
        head = n;
    }

    public void pop1() {
        Node r = head;
        head = head.next;
        r.next = null;
    }

    public int top1() {
        return head.val;
    }

    public int getMin1() {
        return head.min < head.val ? head.min : head.val;
    }

    class Node {
        int val;
        int min;
        Node next;

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }
}
