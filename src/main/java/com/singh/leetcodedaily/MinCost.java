package com.singh.leetcodedaily;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class MinCost {

    public static int minCost(String colors, int[] neededTime) {
        int time = 0;
        Map<Integer, Character> map = new HashMap<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        char[] colorChars = colors.toCharArray();
        char prev = Character.MIN_VALUE;
        for (int i = 0; i < colorChars.length; i++) {
            char c  = colorChars[i];
            if (c == prev) {
                map.put(i, c);
                minHeap.add(neededTime[i]);
            } else {
                for (int j = 0; j < map.size() - 1; j++) {
                    if (minHeap.peek() != null) {
                        time += minHeap.poll();
                    }
                }
                map.clear();
                minHeap.clear();
            }
            map.put(i, c);
            minHeap.add(neededTime[i]);
            prev = c;
        }
        return time;
    }

    public static void main(String[] args) {
        String colors = "abaac";
        int[] neededTime = new int[]{1,2,3,4,5};
        System.out.println(minCost(colors, neededTime));
        colors = "abc";
        neededTime = new int[]{1,2,3};
        System.out.println(minCost(colors, neededTime));
        colors = "aabaa";
        neededTime = new int[]{1,2,3,4,1};
        System.out.println(minCost(colors, neededTime));
    }
}
