package com.singh.old.grind75.week1;

import java.util.*;
public class ThreeSum {

    /*
       2 pointers
       -1, 0, 1, 2, -1, 4; target = 0
       -1, -1, 0, 1, 2, 4
        ^   ^           ^
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    set.add(List.of(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                } else if (sum > 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return new ArrayList<>(set);
    }
}
