package com.singh.old.random.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    /*
        Given an array nums of distinct integers, return all the possible permutations. You can return the answer
        in any order.

        E.g. [1, 2, 3] ->
         [[1, 2, 3], [1,3,2], [2,1,3], [2,3,1] [3,1,2], [3,2,1]]

                     1         2         3
                   2   3     1   3     1   2
                  3     2   3     1   2      1

         [0,1] -> [[0,1], [0,1]]

                 0       1
               1        0

        * all the integers of nums are unique

     */

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        // Arrays.sort(nums);
        backtrack(ret, new ArrayList<>(), nums);
        return ret;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums) {
        if (tempList.size() == nums.length) {
            list.add(new ArrayList<>(tempList));
        } else {
            for (int num : nums) {
                if (tempList.contains(num)) {
                    // element already exists, skip
                    continue;
                }
                tempList.add(num);
                backtrack(list, tempList, nums);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Permutations p = new Permutations();
        int[] nums = new int[]{0, 1};
        System.out.println(p.permute(nums));
        nums = new int[]{1, 2, 3};
        System.out.println(p.permute(nums));
        nums = new int[]{2, 5, 7, 1};
        System.out.println(p.permute(nums));
    }
}
