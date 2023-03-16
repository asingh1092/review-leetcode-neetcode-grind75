package com.singh.neetcode.linkedlist.easy;

import com.singh.testing.linkedlist.ListNode;

public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode merged = new ListNode();
        ListNode dummy = merged;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
//                merged.next = new ListNode(list1.value); // dont need to be new list nodes
                merged.next = list1;
                list1 = list1.next;
            } else {
//                merged.next = new ListNode(list2.value);
                merged.next = list2;
                list2 = list2.next;
            }
            merged = merged.next;
        }
//
//        while (list1 != null) {
//            merged.next = list1;
//            list1 = list1.next;
//            merged = merged.next;
//        }
//
//        while (list2 != null) {
//            merged.next = list2;
//            list2 = list2.next;
//            merged = merged.next;
//        }

        if (list1 != null) {
            merged.next = list1;
        } else if (list2 != null) {
            merged.next = list2;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4, null)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4, null)));
        MergeTwoSortedLists merge = new MergeTwoSortedLists();
        System.out.println(merge.mergeTwoLists(list1, list2));
        list1 = new ListNode();
        list2 = new ListNode();
        System.out.println(merge.mergeTwoLists(list1, list2));
        list1 = new ListNode();
        list2 = new ListNode(32);
        System.out.println(merge.mergeTwoLists(list1, list2));
    }

}
