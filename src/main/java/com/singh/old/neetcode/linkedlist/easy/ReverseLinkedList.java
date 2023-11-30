package com.singh.old.neetcode.linkedlist.easy;

import com.singh.testing.linkedlist.ListNode;

public class ReverseLinkedList {

    /*
        Given the head of a singly linked list, reverse the list, and return the reversed list

        1    2 -> 3 -> 4 -> 5
             n
       prev
                 temp
     */

    public ListNode reverseList(ListNode head) {
        // base case bro
        if (head == null) {
            return head;
        }
        ListNode prev = null;
        ListNode newHead = head;
        while (newHead.next != null) {
            if (prev == null) {
                prev = newHead;
                newHead = newHead.next;
                prev.next = null;
            } else {
                ListNode temp = newHead.next;
                newHead.next = prev;
                prev = newHead;
                newHead = temp;
            }
        }
        newHead.next = prev;
        return newHead;
    }

    public ListNode reverseListIterative(ListNode head) {
        /* iterative solution */
        ListNode newHead = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }

    public ListNode reverseListRecursive(ListNode head) {
        /* recursive solution */
        return reverseListInt(head, null);
    }

    private ListNode reverseListInt(ListNode head, ListNode newHead) {
        if (head == null)
            return newHead;
        ListNode next = head.next;
        head.next = newHead;
        return reverseListInt(next, head);
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ReverseLinkedList r = new ReverseLinkedList();
        System.out.println(r.reverseList(head));

    }
}
