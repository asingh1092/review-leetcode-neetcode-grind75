package com.singh.grind75.week1.easy;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        // map of <num, index>
        Map<Integer, Integer> map = new HashMap<>();
        for (int idx = 0; idx < nums.length; idx++) {
            int value = target - nums[idx];
            if (map.containsKey(value)) {
                return new int[]{idx, map.get(value)};
            } else {
                map.put(nums[idx], idx);
            }
        }
        return new int[]{};
    }
}
