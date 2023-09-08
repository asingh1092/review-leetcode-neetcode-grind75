package com.singh.google.dsa.linkedlists;

public class IntersectionOfTwoLinkedLists {

    public static ListNode intersection(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode a = headA;
        ListNode b = headB;
        int lenA = 1;
        int lenB = 1;
        // go through each LL to figure out which one is shorter
        while (a.next != null) {
            lenA++;
            a = a.next;
        }
        while (b.next != null) {
            lenB++;
            b = b.next;
        }
        // skip difference of longer list and set pointer there
        boolean aShorter = false;
        int diff;
        if (lenB > lenA) {
            aShorter = true;
            diff = lenB - lenA;
        } else {
            diff = lenA - lenB;
        }
        // iterate until a and b are the same objects
        a = headA;
        b = headB;
        if (aShorter) {
            while (diff != 0) {
                diff--;
                b = b.next;
            }
        } else {
            while (diff != 0) {
                diff--;
                a = a.next;
            }
        }
        if (aShorter) {
            while (lenA != 0) {
                lenA--;
                a = a.next;
                b = b.next;
            }
        } else {
            while (lenB != 0) {
                lenB--;
                a = a.next;
                b = b.next;
            }
        }
        if (a == b) {
            return a;
        } else {
            return null;
        }
    }
}
