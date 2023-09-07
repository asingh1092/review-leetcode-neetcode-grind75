package com.singh.google.dsa.linkedlists;

public class LinkedListCycle {

    /*
        use two pointers
        1 slower and 1 faster
        if pointers meet up then we have a cycle
        if loop ends then we dont have a cycle

     */
    public static boolean hasCycle(ListNode head) {
        if (head.next == null || head.next.next == null) {
            return false;
        }
        ListNode slow  = head;
        ListNode fast = head.next;
        ListNode dummy = head;
        while (dummy.next != null || dummy.next.next != null || slow == fast) {
            dummy = dummy.next;
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow == fast;
    }

    public static void main(String[] args) {
       // [3,2,0,-4]
        ListNode head = new ListNode(3);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(-4);
        head.next = node1;
        node1.next = node2;
        node3.next = node2;
        System.out.println(hasCycle(head));
    }
}
