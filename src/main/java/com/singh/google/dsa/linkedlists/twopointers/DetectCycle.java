package com.singh.google.dsa.linkedlists.twopointers;

import com.singh.google.dsa.linkedlists.ListNode;

public class DetectCycle {
    public static ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode pointer = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        while (pointer != slow) {
            pointer = pointer.next;
            slow = slow.next;
        }
        return pointer;
    }
}
