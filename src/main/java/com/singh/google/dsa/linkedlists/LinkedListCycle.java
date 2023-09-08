package com.singh.google.dsa.linkedlists;

public class LinkedListCycle {

    /*
        use two pointers
        1 slower and 1 faster
        if pointers meet up then we have a cycle
        if loop ends then we dont have a cycle

     */
    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null || fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
       // [3,2,0,-4]
        ListNode head = new ListNode(3);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(-4);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node2;
        System.out.println(hasCycle(head));
    }
}
