package com.singh.google.dsa.linkedlists.classic;

import com.singh.google.dsa.linkedlists.ListNode;

public class ReverseList {

    // TODO: FINISH

    /*
        1 -> 2 -> 3 -> 4 -> 5
        ^    ^
        2 -> 1 -> 3 -> 4- -> 5
     */
    public static ListNode reverse(ListNode head) {
        ListNode pointer = head;
        while (pointer.next != null ) {
            ListNode newHead = pointer.next;
            pointer.next = newHead.next;
            newHead.next = head;
            head = newHead;
            pointer = pointer.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println(reverse(head));
    }
}
