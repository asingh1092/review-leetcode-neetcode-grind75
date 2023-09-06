package com.singh.google.dsa.mapsdicts.hashmap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        // map of <number, idx> in nums. Keep adding to map until we find 2 nums that equal target else return -1, -1
        Map<Integer, Integer> hMap = new HashMap<>();
        int pointer = 0;
        for (int num : nums) {
            int value = target - num;
            if (hMap.containsKey(value)) {
                return new int[]{pointer, hMap.get(value)};
            } else {
                hMap.put(num, pointer);
                pointer++;
            }
        }
        return new int[]{-1,-1};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2,7,11, 15}, 9)));
    }
}
