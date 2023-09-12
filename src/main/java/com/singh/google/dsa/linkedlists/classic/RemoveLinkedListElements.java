package com.singh.google.dsa.linkedlists.classic;

import com.singh.google.dsa.linkedlists.ListNode;

public class RemoveLinkedListElements {

    /*
        1 -> 2 -> 6 -> 3 -> 5 -> 6
             ^    ^    ^

        7    7 -> 7 -> 7
            c

     */

    public static ListNode removeElements(ListNode head, int val) {
        ListNode prev = null;
        while (head != null && head.val == val) {
            prev = head;
            head = head.next;
        }
        ListNode pointer = head;
        while (pointer != null) {
            // case where we get val
            if (pointer.val == val) {
                ListNode temp = pointer;
                pointer = pointer.next;
                temp.next = null;
                prev.next = pointer;
            } else {
                prev = pointer;
                pointer = pointer.next;
            }
        }
        return head;
    }

    // recursive
    public ListNode removeElementsRecursive(ListNode head, int val) {
        if(head == null) return null;
        ListNode next = removeElementsRecursive(head.next, val);
        if(head.val == val) return next;
        head.next = next;
        return head;
    }
}
