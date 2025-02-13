package com.singh.old.grind75.week1;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int pointer = 0; pointer < nums.length; pointer++) {
            int val = target - nums[pointer];
            if (map.containsKey(val)) {
                return new int[]{pointer, map.get(val)};
            } else {
                map.put(nums[pointer], pointer);
            }
        }
        return new int[]{};
    }
}
