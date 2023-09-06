package com.singh.google.dsa.mapsdicts.hashset;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FourSum {

    /*
        Given an array nums of n intergers, return an array of all the unique quadruplets
            [nums[a], nums[b], nums[c], nums[d]] such that:
                * 0 <= a, b, c, d < n
                * a, b, c, and d, are distinct.
                * nums[a] + nums[b] + nums[c] + nums[d] = target
        You may return the answer in any order

        e.g. nums = [1, 0, -1, 0, -2, 2] target = 0
                   -2, -1, 0, 0, 1, 2
                    ^   ^        ^  ^

            nums = [2, 2, 2, 2, 2], target = 8

     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Set<List<Integer>> ret = new HashSet<>();
        if (nums.length < 4) {
            return Collections.emptyList();
        }

        return List.of(Collections.emptyList());
    }
}
