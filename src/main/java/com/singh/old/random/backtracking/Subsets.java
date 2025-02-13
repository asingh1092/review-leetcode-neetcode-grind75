package com.singh.old.random.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    /*
        [1,2,3]                      []    1   2   3
                                     ^
                                     [1]
                                     [1,2]
                                     [1,2,3]
                                     [2]
                                     [2,3]
                                     [3]

     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        if (nums.length == 0) {
            return ret;
        }
        backtrack(nums, ret, new ArrayList<>(), 0);
        return ret;
    }

    private void backtrack(int[] nums, List<List<Integer>> ret, List<Integer> potential, int start) {
        ret.add(new ArrayList<>(potential));
        for (int i = start; i < nums.length; i++) {
            potential.add(nums[i]);
            backtrack(nums, ret, potential, i + 1);
            potential.remove(potential.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        Subsets s = new Subsets();
        System.out.println(s.subsets(nums));
    }
}
