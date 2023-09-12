package com.singh.google.dsa.linkedlists.classic;

import com.singh.google.dsa.linkedlists.ListNode;

import java.util.List;

public class OddEvenLinkedList {
    /*
        Given the head of a singly linked list, group all the nodes with odd indices together followed by the
        nodes with even indices, and return the reordered list.

        The first node is considered odd, and the second node is even, and so on

        Solve in O(1) space extra space complexity and O(n) time complexity
           ------>  ------->
        1    2    3   4 -> 5
             ---------->
        1    2    3    4    5
                  o    e    p
        h    eb
                            c

        2 -> 1 -> 3 -> 5 -> 6 -> 4 -> 7
        1    2    3    4    5    6    7
        o    e    c
                  t
        2->3->5->7->1->5->4
     */

    public static ListNode oddEvenLinkedList(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null || head.next.next == null) {
            return head;
        }
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenBegin = head.next;
        ListNode pointer = head.next.next;
        int count = 3;
        while (pointer != null) {
            if (count % 2 == 0) {
                even.next = pointer;
                even = even.next;
            } else {
                odd.next = pointer;
                odd = odd.next;
            }
            pointer = pointer.next;
            count++;
        }
        even.next = null;
        odd.next = evenBegin;
        return head;
    }
}
