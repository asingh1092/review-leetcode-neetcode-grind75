package com.singh.old.google.dsa.mapsdicts.hashset;

import java.util.HashMap;
import java.util.Map;

public class SingleNumber {

    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                int count = map.get(num);
                map.put(num, count + 1);
            } else {
                map.put(num, 1);
            }
        }

        for (int key : map.keySet()) {
            if (map.get(key) == 1) {
                return key;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
    }
}
