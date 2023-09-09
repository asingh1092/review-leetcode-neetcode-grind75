package com.singh.google.dsa.linkedlists.twopointers;

import com.singh.google.dsa.linkedlists.ListNode;

public class IntersectionOfTwoLinkedLists {

    public static ListNode intersection(ListNode headA, ListNode headB) {
        //boundary check
        if(headA == null || headB == null) return null;

        ListNode a = headA;
        ListNode b = headB;

        //if a & b have different len, then we will stop the loop after second iteration
        while( a != b){
            //for the end of first iteration, we just reset the pointer to the head of another linkedlist
            a = a == null? headB : a.next;
            b = b == null? headA : b.next;
        }

        return a;
//        if (headA == null || headB == null) {
//            return null;
//        }
//        ListNode a = headA;
//        ListNode b = headB;
//        int lenA = 1;
//        int lenB = 1;
//        // go through each LL to figure out which one is shorter
//        while (a.next != null) {
//            lenA++;
//            a = a.next;
//        }
//        while (b.next != null) {
//            lenB++;
//            b = b.next;
//        }
//        // skip difference of longer list and set pointer there
//        boolean aShorter = false;
//        int diff;
//        if (lenB > lenA) {
//            aShorter = true;
//            diff = lenB - lenA;
//        } else {
//            diff = lenA - lenB;
//        }
//        // iterate until a and b are the same objects
//        a = headA;
//        b = headB;
//        if (aShorter) {
//            while (diff != 0) {
//                diff--;
//                b = b.next;
//            }
//        } else {
//            while (diff != 0) {
//                diff--;
//                a = a.next;
//            }
//        }
//        if (aShorter) {
//            while (lenA != 0) {
//                lenA--;
//                a = a.next;
//                b = b.next;
//            }
//        } else {
//            while (lenB != 0) {
//                lenB--;
//                a = a.next;
//                b = b.next;
//            }
//        }
//        if (a == b) {
//            return a;
//        } else {
//            return null;
//        }
    }
}
