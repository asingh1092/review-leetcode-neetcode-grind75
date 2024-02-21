package com.singh.grind75.week1;

public class MergeTwoSortedLists {

    /*
        1    3     5
        1    2     4


        1 -> 1 ->
     */

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head;
        ListNode follower;
        if (list1.val < list2.val) {
            head = list1;
        } else {
            head = list2;
        }
        follower = head.next;
        while (list1.next != null && list2.next != null) {
            if (list1.val < list2.val) {
                follower = list1;
                list1 = list1.next;
                follower.next = list2;
            } else {
                follower = list2;
                list2 = list2.next;
                follower.next = list1;
            }
        }
        if (list1.next != null) {
            follower.next = list1.next;
        }
        return head;
    }
}
