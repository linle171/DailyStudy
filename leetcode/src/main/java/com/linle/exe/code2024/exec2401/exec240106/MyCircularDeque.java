package com.linle.exe.code2024.exec240106;


import org.junit.Test;

/**
 * @description: 641. 设计循环双端队列 middle
 * @author: chendeli
 * @date: 2024-01-06 18:59
 */
public class MyCircularDeque {
    /**
     * 设计实现双端队列。
     *
     * 实现 MyCircularDeque 类:
     *
     * MyCircularDeque(int k) ：构造函数,双端队列最大为 k 。
     * boolean insertFront()：将一个元素添加到双端队列头部。 如果操作成功返回 true ，否则返回 false 。
     * boolean insertLast() ：将一个元素添加到双端队列尾部。如果操作成功返回 true ，否则返回 false 。
     * boolean deleteFront() ：从双端队列头部删除一个元素。 如果操作成功返回 true ，否则返回 false 。
     * boolean deleteLast() ：从双端队列尾部删除一个元素。如果操作成功返回 true ，否则返回 false 。
     * int getFront() )：从双端队列头部获得一个元素。如果双端队列为空，返回 -1 。
     * int getRear() ：获得双端队列的最后一个元素。 如果双端队列为空，返回 -1 。
     * boolean isEmpty() ：若双端队列为空，则返回 true ，否则返回 false  。
     * boolean isFull() ：若双端队列满了，则返回 true ，否则返回 false 。
     *
     * 示例 1：
     *
     * 输入
     * ["MyCircularDeque", "insertLast", "insertLast", "insertFront", "insertFront", "getRear", "isFull", "deleteLast", "insertFront", "getFront"]
     * [[3], [1], [2], [3], [4], [], [], [], [4], []]
     * 输出
     * [null, true, true, true, false, 2, true, true, true, 4]
     *
     * 解释
     * MyCircularDeque circularDeque = new MycircularDeque(3); // 设置容量大小为3
     * circularDeque.insertLast(1);			        // 返回 true
     * circularDeque.insertLast(2);			        // 返回 true
     * circularDeque.insertFront(3);			        // 返回 true
     * circularDeque.insertFront(4);			        // 已经满了，返回 false
     * circularDeque.getRear();  				// 返回 2
     * circularDeque.isFull();				        // 返回 true
     * circularDeque.deleteLast();			        // 返回 true
     * circularDeque.insertFront(4);			        // 返回 true
     * circularDeque.getFront();				// 返回 4
     *
     * 提示：
     *
     * 1 <= k <= 1000
     * 0 <= value <= 1000
     * insertFront, insertLast, deleteFront, deleteLast, getFront, getRear, isEmpty, isFull  调用次数不大于 2000 次
     */

    class ListNode07{
        int val;
        ListNode07 pre;
        ListNode07 next;

        ListNode07(){
        }

        public void setHead(ListNode07 head) {
            this.pre = head;
        }

        public void setNext(ListNode07 next) {
            this.next = next;
        }

        public void setVal(int val) {
            this.val = val;
        }
        ListNode07(int val){
           this.val =val;
        }

        ListNode07(int val, ListNode07 pre, ListNode07 next){
            this.val = val;
            this.pre = pre;
            this.next = next;
        }



    }

    private ListNode07 head;

    private ListNode07 tail;
    private int cap;

    private int len;

    public MyCircularDeque(){
    }
    public MyCircularDeque(int k) {
        this.len = k;
        this.cap = 0;
    }

    public boolean insertFront(int value) {
        if(cap == len){
           return false;
        }
        if(cap == 0){
           head =  new ListNode07(value);
           tail = head;
        }else {
            head.pre = new ListNode07(value,null,head);
            head = head.pre;
        }
        cap++;
        return true;
    }

    public boolean insertLast(int value) {
        if(cap == len){
            return false;
        }
        if(cap == 0){
            tail =  new ListNode07(value);
            head = tail;
        }else {
            tail.next = new ListNode07(value,tail,null);
            tail = tail.next;
        }
        cap++;
        return true;
    }

    public boolean deleteFront() {
        if(cap == 0){
            return false;
        }
        if(cap == 1){
            head = null;
            tail = null;
        }else {
            head = head.next;
        }
        cap--;
        return true;
    }

    public boolean deleteLast() {
        if(cap == 0){
            return false;
        }
        if(cap == 1){
            head = null;
            tail = null;
        }else {
            tail = tail.pre;
        }
        cap--;
        return true;
    }

    public int getFront() {
        return cap == 0 ? -1: head.val;
    }

    public int getRear() {
        return cap == 0 ? -1: tail.val;
    }

    public boolean isEmpty() {
       return cap == 0;
    }

    public boolean isFull() {
        return cap == len;
    }

    /**
     * 总结：设计双向队列
     * 1、要注意边界问题
     * 2、新增节点要关联前后节点
     */
    @Test
    public void test1(){
        MyCircularDeque myCircularDeque = new MyCircularDeque(8);
        myCircularDeque.insertFront(5);
        myCircularDeque.deleteFront();
        myCircularDeque.insertLast(3);
        myCircularDeque.insertLast(7);
        myCircularDeque. insertLast(7);
        myCircularDeque.deleteLast();
        myCircularDeque.insertLast(4);
    }
}
