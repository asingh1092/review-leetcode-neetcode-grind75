package com.singh.google.dsa.linkedlists;

public class DoublyListNode {

    public DoublyListNode prev;
    public int val;
    public  DoublyListNode next;

    public DoublyListNode() {

    }
    public DoublyListNode(int val) {
        this.val = val;
    }
    public DoublyListNode(int val, DoublyListNode prev, DoublyListNode next) {
        this.prev = prev;
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "DoublyListNode{" +
                "prev=" + prev +
                ", val=" + val +
                ", next=" + next +
                '}';
    }
}
