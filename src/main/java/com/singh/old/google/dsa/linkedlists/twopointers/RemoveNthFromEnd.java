package com.singh.old.google.dsa.linkedlists.twopointers;

import com.singh.old.google.dsa.linkedlists.ListNode;

public class RemoveNthFromEnd {

    public static ListNode removeNthFromEnd(ListNode head, int n) {
//        if (head == null) {
//            return null;
//        }
//        ListNode toEnd = head;
//        ListNode diff = head;
//        int posOfToEnd = 1;
//        while (toEnd.next != null) {
//            if (n < posOfToEnd) {
//                diff = diff.next;
//            }
//            toEnd = toEnd.next;
//            posOfToEnd++;
//        }
//        diff.next = diff.next.next;
//        return head;
        ListNode fast = head, slow = head;
        for (int i = 0; i < n; i++) fast = fast.next;
        if (fast == null) return head.next;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println(removeNthFromEnd(head, 2));
        ListNode head1 = new ListNode(1);
        System.out.println(removeNthFromEnd(head1, 1));
    }
}
