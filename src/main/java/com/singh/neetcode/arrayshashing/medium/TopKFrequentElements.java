package com.singh.neetcode.arrayshashing.medium;

import java.util.*;

public class TopKFrequentElements {


    /*
        Given an itneger array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

        INPUT: [1,1,1,2,2,3]; k = 2
        OUTPUT: [1, 2]

        INPUT: [1], k = 1
        OUTPUT: [1]

       Questions: are they sorted????? if not sort first, then interate over each num in nums and see if it appears k times
       Big O(n logn)

      or just use a hashmap where the key is the num itself, and value is a count. If value is k then it'll be a value that will be added to the result
        Big O: O(n)
     */

    public static int[] kFrequentElements(int[] nums, int k) {
        Map<Integer, Integer> hMap = new HashMap<>();
        List<Integer> ret = new ArrayList<>();
        for (int num : nums) {
            if (!hMap.containsKey(num)) {
                int count = 1;
                hMap.put(num, count);
            }
            if (hMap.get(num) == k && !ret.contains(num)) {
                ret.add(num);
            } else {
                hMap.put(num, hMap.get(num) + 1);
            }
        }
        return toIntArray(ret);
    }

    private static int[] toIntArray(List<Integer> list)  {
        int[] ret = new int[list.size()];
        int i = 0;
        for (Integer e : list)
            ret[i++] = e;
        return ret;
    }


    /*
       [1, 1, 1 , 2, 2, 3] k = 2

       max heap -> always keep max value up top



     */
    public static int[] KthFrequentElements(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[]{};
        }
        Queue<Map.Entry<Integer, Integer>> priority = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue()); // max heap
        Map<Integer, Integer> hashMap = new HashMap<>(); // frequency map
        for (int num : nums) {
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        }

        priority.addAll(hashMap.entrySet());

        int[] ret = new int[k];
        for (int i = 0; i< k; i++) {
            ret[i] = priority.poll().getKey();
        }
        return ret;
    }


    // TODO Solution with bucket sort


    public static void main(String[] args) {
        System.out.println(Arrays.toString(KthFrequentElements(new int[]{1, 1, 1, 2, 2, 3}, 2)));
        System.out.println(Arrays.toString(KthFrequentElements(new int[]{}, 1)));
        System.out.println(Arrays.toString(KthFrequentElements(new int[]{1}, 1)));

        System.out.println(Arrays.toString(KthFrequentElements(new int[]{1, 1, 1, 2, 2, 3}, 2)));
        System.out.println(Arrays.toString(KthFrequentElements(new int[]{}, 1)));
        System.out.println(Arrays.toString(KthFrequentElements(new int[]{1}, 1)));
        Map<Integer, Integer> hMap = new HashMap<>();
    }
}
