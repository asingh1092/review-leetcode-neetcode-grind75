package com.singh.neetcode.arrayshashing.medium;

import java.util.*;

public class LongestConsecutiveSequence {

    /*
        Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence
        You must write an algo that runs in O(n) time.

        Ex 1: nums = [100,4,200,1,3,2] -> [1 2 3 4] -> 4
        Ex 2: nums = [0,3,7,2,5,8,4,6,0,1] -> [0,1,2,3,4,5,6,7,8] -> 9

                    1, 2, 3, 4, 100, 200
                    0, 0, 1, 2, 3, 4, 5, 6, 7, 8
                    0, 3, 5, 7, 8, 9, 10, 11, 12
     */
    public int lcs(int[] nums) {
        int lcs = 0;
        int size = nums.length;
        Set<Integer> hSet = new HashSet<>(size);
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            int backwards = i;
            while (backwards != 0) {
                if (hSet.contains(nums[backwards] - 1)) {
                    count++;
                }
                backwards--;
            }
            lcs = Math.max(lcs, count);
            hSet.add(nums[i]);
        }
        return lcs;
    }

    public int lcsp2(int[] nums) {
        int ret = 0;
        Set<Integer> hset = new HashSet<>();
        for (int n : nums) {
            hset.add(n);
        }
        for (int x : hset) {
            if (!hset.contains(x - 1)) {
                int y = x + 1;
                while (hset.contains(y)) {
                    y += 1;
                }
                ret = Math.max(ret, y - x);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        LongestConsecutiveSequence lcs = new LongestConsecutiveSequence();
        System.out.println(lcs.lcsp2(new int[]{100,4,200,1,3,2}));
        System.out.println(lcs.lcsp2(new int[]{0,3,7,2,5,8,4,6,0,1}));
    }
}
