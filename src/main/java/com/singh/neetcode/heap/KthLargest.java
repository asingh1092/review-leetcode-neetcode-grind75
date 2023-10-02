package com.singh.neetcode.heap;

import java.util.PriorityQueue;

public class KthLargest {

    int k;
    PriorityQueue<Integer> minHeap;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        minHeap = new PriorityQueue<>();
        for (int n : nums) {
            minHeap.add(n);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
    }

    /*
        4, 5, 8, 2
        2, 4, 5, 8
        2, 3, 4, 5, 8 -> 4
        2, 3, 4, 5, 5, 8 -> 5


     */
    public int add(int val) {
        this.minHeap.add(val);
        if (minHeap.size() > k) {
            minHeap.poll();
        }
        return !minHeap.isEmpty() ? minHeap.peek() : -1;
    }

    public static void main(String[] args) {
        KthLargest kth = new KthLargest(3, new int[]{4, 5, 8, 2});
        System.out.println(kth.add(3));
        System.out.println(kth.add(5));
        System.out.println(kth.add(10));
        System.out.println(kth.add(9));
        System.out.println(kth.add(4));
    }
}
