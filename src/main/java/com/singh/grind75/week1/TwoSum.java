package com.singh.grind75.week1;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        int[] ret = new int[2];
        int size = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < size; i++) {
            int val = target - nums[i];
            if (map.containsKey(val)) {
                ret[0] = i;
                ret[1] = map.get(val);
                return ret;
            } else {
                map.put(nums[i], i);
            }
        }
        return ret;
    }
}
