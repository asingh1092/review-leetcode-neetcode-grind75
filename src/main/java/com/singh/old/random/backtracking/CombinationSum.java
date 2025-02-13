package com.singh.old.random.backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    /*
        Given an array of distinct integers candidates and a target integer target, return a list of all unique
        combinations of candidates where the chosen numbers sum to target. you may return the combinations in any
        order.

        The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the
        frequency of at least one of the chosen numbers is different.

        The test cases are generated such that the number of unique combinations that sum up to target is less than
        150 combinations for the given input.

        e.g. candidates = [2,3,6,7], target = 7 -> [[2,2,3],[7]]

            [2,3,5] target = 8
            [[2,2,2,2],[2,3,3],[3,5]]

                    2               3       6  7
                 2    3 6 7
              2  3      6  7
            2
     */

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        // Arrays.sort(candidates);
        backtrack(candidates, ret, new ArrayList<>(), target, 0);
        return ret;
    }

    private void backtrack(int[] input, List<List<Integer>> ret, ArrayList<Integer> tempList, int remain, int start) {
        if (remain < 0) {
            return;
        } else if (remain == 0) {
            ret.add(new ArrayList<>(tempList));
        } else { // remain > 0
            for (int i = start; i < input.length; i++) {
                tempList.add(input[i]);
                backtrack(input, ret, tempList, remain - input[i], i); // start is i here and not i + 1 because we can use the same num many times
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        CombinationSum cs = new CombinationSum();
        System.out.println(cs.combinationSum(new int[]{2,3,7}, 7));
        System.out.println(cs.combinationSum(new int[]{2,3,5}, 8));
    }
}
