package com.singh.old.grind75.week1;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

    public int majorityElement(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int majorityThreshold = nums.length / 2;
        Map<Integer, Integer> freq = new HashMap<>();
        for (int n : nums) {
            if (freq.containsKey(n) && freq.get(n) + 1 > majorityThreshold) {
                return n;
            } else {
                freq.put(n, freq.getOrDefault(n, 0) + 1);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        MajorityElement element = new MajorityElement();
        int[] nums = new int[]{3, 2, 3};
        System.out.println(element.majorityElement(nums));
        nums = new int[]{2, 2, 1, 1, 1, 2, 2};
        System.out.println(element.majorityElement(nums));
    }
}
