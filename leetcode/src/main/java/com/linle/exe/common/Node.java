package com.linle.exe.common;

import lombok.Data;


@Data
public class Node{
    public int val;
    public Node next;
    public Node random;


    public Node(){}
    public  Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }


}