package com.singh.old.random.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class RelativeRanks {

    public static String[] findRelativeRanks(int[] scores) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int score : scores) {
            maxHeap.add(score);
        }
        System.out.println(maxHeap);

        String[] ret = new String[scores.length];
        int idx = 0;
        while (!maxHeap.isEmpty()) {
            if (idx == 0) {
                maxHeap.poll();
                ret[idx] = "Gold Medal";
            } else if (idx == 1) {
                maxHeap.poll();
                ret[idx] = "Silver Medal";
            } else if (idx == 2) {
                maxHeap.poll();
                ret[idx] = "Bronze Medal";
            } else {
                ret[idx] = String.valueOf(maxHeap.poll());
            }
            idx++;
        }
        return ret;
    }


    public static void main(String[] args) {
        int[] scores = new int[]{3, 2, 4, 4, 1,};
        System.out.println(Arrays.toString(findRelativeRanks(scores)));
    }
}
