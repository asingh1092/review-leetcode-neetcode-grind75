package com.singh.old.google.dsa.linkedlists;

public class MergeTwoSortedLists {

    /*
        Are the two lists the same size?
        Can we use extra space?
        If so, space = O(n+m)
               time = O(n+m)

        just use the lists them selves

        1 2 3 4
        b
          ^
        1 3 4
          ^
     */

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        ListNode dummy = new ListNode(0);
        ListNode pointer = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                pointer.next = list1;
                list1 = list1.next;
            } else {
                pointer.next = list2;
                list2 = list2.next;
            }
            pointer = pointer.next;
        }
        pointer.next = list1 == null ? list2 : list1;
        return dummy.next;
    }

    public ListNode mergeTwoListsRecursive(ListNode l1, ListNode l2){
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1.val < l2.val){
            l1.next = mergeTwoListsRecursive(l1.next, l2);
            return l1;
        } else{
            l2.next = mergeTwoListsRecursive(l1, l2.next);
            return l2;
        }
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        System.out.println(mergeTwoLists(list1, list2));

    }
}
