package com.linle.exe;


import org.junit.Test;

/**
 * @description:
 * @author: chendeli
 * @date: 2024-04-26 19:31
 */
public class TestCal {
    class Node{
        Integer value;
        Node next;

        public Node(){
        }
        public Node(Integer value){
            this.value = value;
        }
    }

    @Test
    public void test1(){
        Node headL = new Node(1);
        headL.next = new Node(3);
        headL.next.next = new Node(5);

        Node headR = new Node(2);
        headR.next = new Node(4);
        headR.next.next = new Node(6);
        Node result = new Node();
//        Node node = mergeTwoLists(headR, headL);
//        mergeTwoLists1(headR,headL,result);
        Node node = mergeTwoLists(headR, headL);
        System.out.println(node);
//        System.out.println(result);
//        System.out.println(result);
    }
    public void main(String[] args) {
//        Node headL = new Node(1);
//        headL.next = new Node(3);
//        headL.next.next = new Node(5);
//
//        Node headR = new Node(2);
//        headR.next = new Node(4);
//        headR.next.next = new Node(6);
//        Node result = new Node();
////        Node node = mergeTwoLists(headR, headL);
//        mergeTwoLists1(headR,headL,result);
//        System.out.println(result);

    }

    private void mergeTwoLists1(Node headR, Node headL, Node result) {
        if(headR == null || headL == null){
            result.next = headL == null ? headR : headL;
            return;
        }
        if(headR.value > headL.value){
            result.next = headL;
            headL = headL.next;
        }else {
            result.next = headR;
            headR = headR.next;
        }
        mergeTwoLists1(headR,headL,result.next);
    }

    private Node mergeTwoLists(Node headR, Node headL) {
        Node result = new Node();
        Node pre = result;
        while(headL != null && headR != null){
            if(headL.value > headR.value){
                pre.next = headR;
                pre = pre.next;
                headR = headR.next;
            }else {
                pre.next = headL;
                pre = pre.next;
                headL = headL.next;
            }
        }

        pre.next = headL != null ? headL : headR;
        return result.next;
    }
}
