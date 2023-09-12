package com.singh.google.dsa.linkedlists.classic;

import com.singh.google.dsa.linkedlists.ListNode;

public class ReverseList {

    // TODO: FINISH

    /*
         1 <- 2 <- 3    4 -> 5
                        h    n
                   p

        2 -> 1 -> 3 -> 4- -> 5
     */
    public static ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    // recursive solution
    public ListNode reverseList(ListNode head) {
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
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println(reverse(head));
    }
}
