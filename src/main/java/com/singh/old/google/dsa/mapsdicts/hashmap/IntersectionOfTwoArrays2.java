package com.singh.old.google.dsa.mapsdicts.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionOfTwoArrays2 {


    public int[] intersect(int[] nums1, int[] nums2) {
        // first make a count map of each num in nums1 <Integer, freq
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int i : nums1) {
            if (freqMap.containsKey(i)) {
                freqMap.put(i, freqMap.get(i) + 1);
            } else {
                freqMap.put(i, 1);
            }
        }

        List<Integer> ret = new ArrayList<>();
        // second go through nums2 and see if num exists in count map, remove 1 count, and add to list to be returned
        for (int j : nums2) {
            if (freqMap.containsKey(j) && freqMap.get(j) > 0) {
                ret.add(j);
                freqMap.put(j, freqMap.get(j) - 1);
            }
        }

        int[] realRet = new int[ret.size()];
        for (int i = 0; i < realRet.length; i++) {
            realRet[i] = ret.get(i);
        }

        return realRet;
    }
}
