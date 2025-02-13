package com.singh.old.random.backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumA {


    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        if (nums.length == 0) {
            return ret;
        }
        backtrack(nums, ret, new ArrayList<>(), target, 0);
        return ret;
    }

    private void backtrack(int[] nums, List<List<Integer>> ret, List<Integer> potential, int left, int start) {
        if (left == 0) {
            ret.add(new ArrayList<>(potential));
        } else if (left < 0) {
            return;
        } else {
            for (int i = start; i < nums.length; i++) {
                potential.add(nums[i]);
                backtrack(nums, ret, potential, left - nums[i], i);
                potential.remove(potential.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        CombinationSumA cs = new CombinationSumA();
        System.out.println(cs.combinationSum(new int[]{2, 3, 7}, 7));
        System.out.println(cs.combinationSum(new int[]{2, 3, 5}, 8));
    }
}
