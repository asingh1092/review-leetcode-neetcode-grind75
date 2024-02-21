package com.singh.grind75.week1;

import java.util.*;

public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> seen = new HashMap<>();
        // key == num, value = position
        for (int i = 0; i < nums.length; i++) {
            int toFind = target - nums[i];
            if (seen.containsKey(toFind)) {
                return new int[]{i, seen.get(toFind)};
            } else {
                seen.put(nums[i], i);
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        System.out.println(twoSum(new int[]{2, 7, 5, 2, 3}, 9));
    }
}
