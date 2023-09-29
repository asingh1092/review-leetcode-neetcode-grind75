package com.singh.neetcode.heap;

import java.util.PriorityQueue;

public class LastStoneWeight {

    /*
        [2, 7, 4, 1, 8, 1]

        [8, 7, 4, 2, 1, 1]
         ^  ^
         [4, 2, 1, 1, 1]
         [2, 1, 1, 1]
         [1, 1, 1]
         [1]

         [2,7,4]
         [7,4,2]
         [3,2]
         [1]

     */
    public int lastStoneWeight(int[] stones) {
        // max heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int n : stones) {
            maxHeap.add(n);
        }
        while (maxHeap.size() >= 2) {
            int y = maxHeap.poll();
            int x = maxHeap.poll();
            if (x != y) {
                maxHeap.add(y - x);
            }
        }
        return !maxHeap.isEmpty() ? maxHeap.peek() : 0;
    }

    public static void main(String[] args) {
        LastStoneWeight l = new LastStoneWeight();
        System.out.println(l.lastStoneWeight(new int[]{2, 7, 4, 1, 8, 1}));
    }
}
