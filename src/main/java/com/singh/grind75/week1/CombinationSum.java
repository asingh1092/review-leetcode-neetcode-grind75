package com.singh.grind75.week1;

import java.util.*;

public class CombinationSum {

    /*
           2 3 5 7 = 7


          2                           3                  6 x                    7 -
       2   3  5 7                 2   3  6 7        2  3  6  7
     3-                          2 -

     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates.length == 0) {
            return new ArrayList<>();
        }
        Set<List<Integer>> set = new HashSet<>();
        List<Integer> sum = new ArrayList<>();
        backtrack(sum, set, candidates, target, 0);
        return new ArrayList<>(set);
    }

    private void backtrack(List<Integer> sum, Set<List<Integer>> set, int[] candidates, int left, int pos) {
        if (left == 0) {
            set.add(new ArrayList<>(sum));
            return;
        } else if (left < 0) {
            return;
        } else {
            for (int i = pos; i < candidates.length; i++) {
                sum.add(candidates[i]);
                backtrack(sum, set, candidates, left - candidates[i], i);
                sum.remove(sum.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] candidates = new int[]{2,3,6,7};
        CombinationSum cs = new CombinationSum();
        System.out.println(cs.combinationSum(candidates, 7));
    }
}
