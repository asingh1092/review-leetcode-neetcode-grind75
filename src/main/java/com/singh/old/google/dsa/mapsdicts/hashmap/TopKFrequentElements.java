package com.singh.old.google.dsa.mapsdicts.hashmap;

import java.util.*;

public class TopKFrequentElements {

    // bucket sort
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();

        // add frequency of n seen in nums <key,value> = <num, count>
        for (int n : nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }

        TreeMap<Integer, List<Integer>> freqMap = new TreeMap<>();
        for(int num : count.keySet()){
            int freq = count.get(num);
            if(!freqMap.containsKey(freq)){
                freqMap.put(freq, new LinkedList<>());
            }
            freqMap.get(freq).add(num);
        }

        int[] ret = new int[k];
        for (int i = 0; i < k; i++) {
            Map.Entry<Integer, List<Integer>> entry = freqMap.pollLastEntry();
            List<Integer> list = entry.getValue();
            for (int n : list) {
                if (i > k) {
                    break;
                }
                ret[i] = n;
                if (list.size() != 1) {
                    i++;
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,2,2,3};
        System.out.println(Arrays.toString(topKFrequent(nums, 2)));
    }
}
