package com.singh.neetcode.twopointers;

import java.util.*;

public class ThreeSum {

    /*
        Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that
        i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

        Notice that the solution set must not contain duplicate triplets.
        [-1,0,1,2,-1,-4] -> [[-1,-1,2],[-1,0,1]]
        [0,1,1] = []
        [0,0,0] = [[0,0,0]]

        [0, 1, 1]
         ^     ^
        [0,0,0]
         ^   ^
        [-4,-1,-1,0,1,2,3]
             ^ ^          ^

        Use a set + two pointers
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> ret = new HashSet<>();
        if (nums.length < 3) {
            return Collections.emptyList();
        }
        // sort nums -> O(nlogn)
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    ret.add(Arrays.asList(nums[i], nums[j++], nums[k--]));
                } else if (sum > 0) {
                    k--;
                } else if (sum < 0) {
                    j++;
                }
            }
        }
        return new ArrayList<>(ret);
    }

    public static void main(String[] args) {
        ThreeSum ts = new ThreeSum();
        System.out.println(ts.threeSum(new int[]{-1,0,1,2,-1,-4}));
        System.out.println(ts.threeSum(new int[]{0, 1, 1}));
        System.out.println(ts.threeSum(new int[]{0,0,0}));
    }
}
