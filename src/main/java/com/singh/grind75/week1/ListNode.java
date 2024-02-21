package com.singh.grind75.week1;

public class ListNode {

    int val;
    ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode(" + this.val + ", " +  this.next + ")";
    }
}
