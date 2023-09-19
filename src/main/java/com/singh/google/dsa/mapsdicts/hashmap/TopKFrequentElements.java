package com.singh.google.dsa.mapsdicts.hashmap;

import java.util.*;

public class TopKFrequentElements {

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();

        // add frequency of n seen in nums <key,value> = <num, count>
        for (int n : nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }

        // make another map such that freq is key <key, value = <count, List<num>>

        return new int[]{};
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 2, 3, 4, 1};
        System.out.println(Arrays.toString(topKFrequent(nums, 2)));
    }
}
