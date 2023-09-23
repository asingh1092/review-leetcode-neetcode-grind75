package com.singh.neetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        backtrack(nums, ret, new ArrayList<>());
        return ret;
    }

    public void backtrack(int[] nums, List<List<Integer>> ret, List<Integer> potential) {
        if (potential.size() == nums.length) {
            ret.add(new ArrayList<>(potential));
        } else {
            for (int num : nums) {
                if (potential.contains(num)) {
                    continue;
                }
                potential.add(num);
                backtrack(nums, ret, potential);
                potential.remove(potential.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Permutations().permute(new int[]{1,2,3}));
    }
}
