package com.singh.neetcode.stack.medium;

import java.util.EmptyStackException;

public class MinStack {
    private Node head;

    public MinStack() {
    }
    public void push(int val) {
        if (head == null) {
            head = new Node(val, val, null);
        } else {
            head = new Node(val, Math.min(head.min, val), head);
        }
    }

    public void pop() {
        if (head == null) {
            throw new EmptyStackException();
        } else {
            head = head.next;
        }
    }

    public int top() {
        if (head == null) {
            throw new EmptyStackException();
        } else {
            return head.val;
        }
    }

    public int getMin() {
        if (head == null) {
            throw new EmptyStackException();
        } else {
            return head.min;
        }
    }

    private class Node {
        int val;
        int min;
        Node next;

        private Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin()); // return -3
        minStack.pop();
        System.out.println(minStack.top()); // return 0
        System.out.println(minStack.getMin()); // return -2
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
