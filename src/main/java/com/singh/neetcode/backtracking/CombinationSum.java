package com.singh.neetcode.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CombinationSum {
    /*

        2 3 6 7     -----             7
        [2,2,3] [7]
                                   []
                         2                                     3      6      7
                  2    3   6   7
            2    3   6   7
         2     [7]
      x8 > 7   [2,2,3]
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        backtrack(candidates, ret, target, 0, new ArrayList<>(), 0);
        return ret;
    }

    private void backtrack(int[] candidates, List<List<Integer>> ret, int target, int sum, ArrayList<Integer> potential, int start) {
        if (sum == target) {
            ret.add(new ArrayList<>(potential));
        } else if (sum > target) {
            return;
        } else {

            for (int i = start; i < candidates.length; i++) {
                potential.add(candidates[i]);
                backtrack(candidates, ret, target, sum + candidates[i], potential, i); // i here is not i + 1 because we can use the same number over again
                potential.remove(potential.size() - 1);
            }
        }

    }

    public static void main(String[] args) {
        CombinationSum combinationSum = new CombinationSum();
        System.out.println(combinationSum.combinationSum(new int[]{2,3,6, 7}, 7));
    }
}
