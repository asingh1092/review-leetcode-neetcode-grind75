package com.singh.old.neetcode.stack;

public class StackNode {

    public int value;
    public StackNode next;

    public StackNode() {}

    public StackNode(int value) {
        this.value = value;
    }

    public StackNode(StackNode next) {
        this.next = next;
    }

    public StackNode(int value, StackNode next) {
        this.value = value;
        this.next = next;
    }

    @Override
    public String toString() {
        return "StackNode{" +
                "value=" + value +
                ", next=" + next +
                '}';
    }

}
