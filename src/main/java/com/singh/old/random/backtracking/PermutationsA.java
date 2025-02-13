package com.singh.old.random.backtracking;

import java.util.ArrayList;
import java.util.List;

public class PermutationsA {

    public List<List<Integer>> permutations(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        if (nums.length == 0) {
            return ret;
        }
        backtrack(nums, ret, new ArrayList<>());
        return ret;
    }

    private void backtrack(int[] nums, List<List<Integer>> ret, List<Integer> potential) {
        if (potential.size() == nums.length) {
            ret.add(new ArrayList<>(potential));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (potential.contains(nums[i])) {
                    continue;
                }
                potential.add(nums[i]);
                backtrack(nums, ret, potential);
                potential.remove(potential.size() - 1);
            }
        }
    }
}
