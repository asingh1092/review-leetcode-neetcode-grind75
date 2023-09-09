package com.singh.google.dsa.linkedlists.twopointers;

class Node {
    public int val;
    public Node next;

    public Node(int val) {
        val = this.val;
    }

    public Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }
}

public class EvenOddLinkedList {
    public static String isEvenOdd(Node head) {
        int total = 0;
        if (head == null) {
            return "Even";
        }
        Node pointer = head;
        total++;
        while (pointer.next != null) {
            total++;
            pointer = pointer.next;
        }
        return evenOrOddString(total);
    }

    private static String evenOrOddString(int value) {
        if (value % 2 == 0) {
            return "even";
        } else {
            return "odd";
        }
    }

    public static void main(String[] args) {
        Node head = new Node(9, new Node(4, new Node(3)));
        System.out.println(isEvenOdd(head));
        Node head2 = new Node(12, new Node(52, new Node(10, new Node(47, new Node(95, new Node(0))))));
        System.out.println(isEvenOdd(head2));
    }
}
