package com.singh.grind;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

    public int majorityElement(int[] nums) {
        int ret = Integer.MAX_VALUE;
        int majority = nums.length / 2;
        Map<Integer, Integer> map  = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
            if (map.get(n) > majority) {
                ret = n;
            }
        }
        return ret;
    }
}
