package com.singh.old.google.dsa.stacksqueues.stack;

import java.util.EmptyStackException;

public class MinStack {

    MinNode head = null;
    public MinStack() {
    }


    public void push(int val) {
        if (head != null) {
            int min = Math.min(head.min, val);
            head = new MinNode(val, min, head);
        } else {
            head = new MinNode(val, val, null);
        }
    }


    public void pop() {
        if (head != null) {
            head = head.next;
        } else {
            throw new EmptyStackException();
        }
    }

    public int top() {
        if (head != null) {
            return head.val;
        } else {
            throw new EmptyStackException();
        }
    }


    public int getMin() {
        if (head != null) {
            return head.min;
        } else {
            throw new EmptyStackException();
        }
    }


}

class MinNode {
    int val;
    int min;
    MinNode next;

    public MinNode(int val) {
        this.val = val;
    }

    public MinNode(int val, int min, MinNode next) {
        this.val = val;
        this.min = min;
        this.next = next;
    }
}
