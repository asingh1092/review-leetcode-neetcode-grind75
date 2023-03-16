package com.singh.neetcode.linkedlist;

import com.singh.testing.linkedlist.ListNode;

import java.util.Stack;

public class ReorderList {

    /*
           1 -> 2 -> 3 -> 4 -> 5 -> 6 .........-> n - 1 -> n

           1 3 5   -> 1 6 2 5 3 4
           2 4 6      1 n 2 n-1 3 n-2 3
           1 2 3 4 5 6
               ^     ^
           1 6 2 5 3 4
           1 8 2 7 3 6 4 5
           1 2 3 4 5 6 7 8
2 pointers       ^       ^
     List: 1 2 3 4 5 6 7 8
                   ^
     Stack: 1 2 3 4

           1 -> 8 -> 2-> 7 -> 3 -> 6 -> 4 -> 5

           1 2 3
     */

    public ListNode reorderList(ListNode head) {
        ListNode dummy = head;
        ListNode slow = dummy;
        ListNode fast = dummy.next;
        Stack<ListNode> stack = new Stack<>();
        while (fast != null) {
            stack.push(slow);
            slow = slow.next;
            fast = fast.next.next;
        }

        while (slow.next != null) {
            ListNode value = stack.pop();
            value.next = slow;
            slow = slow.next;
        }

        return dummy;
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, null))));
        ListNode list2 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
        ReorderList reorderList = new ReorderList();
        System.out.println(reorderList.reorderList(list1));
        System.out.println(reorderList.reorderList(list2));
    }

}
