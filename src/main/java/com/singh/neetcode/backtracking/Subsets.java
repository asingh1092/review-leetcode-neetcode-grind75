package com.singh.neetcode.backtracking;

import java.util.*;

public class Subsets {

    /*
        Given an integer array nums of unique elements, return all possible subsets (the power set).

        The solution set must not contain duplicate subsets. Return the solution in any order

        nums = [1,2,3]
                2 2 2 = 2^n num of subsets

        Time: O(n * 2^n)
        Backtracking -> brute force and most efficient way to solve this

                        []
                    1               []
             2          []      2       []
          3    []     3   []  3   []  3   []
      [1,2,3] [1,2] [1,3] [1]  [2,3] [2] [3] []
      // TODO: Backtracking - https://leetcode.com/problems/subsets/solutions/27281/a-general-approach-to-backtracking-questions-in-java-subsets-permutations-combination-sum-palindrome-partitioning/
     */

    public List<List<Integer>> subsets(List<Integer> nums) {
        List<List<Integer>> ret = new ArrayList<>();
        backtrack(nums, ret, new ArrayList<>(), 0);
        return ret;
    }

    public void backtrack(List<Integer> nums, List<List<Integer>> ret, List<Integer> potential, int pos) {
        ret.add(new ArrayList<>(potential));
        for(int i = pos; i < nums.size(); i++){
            potential.add(nums.get(i));
            backtrack(nums, ret, potential, i + 1);
            potential.remove(potential.size() - 1);
        }
    }

    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        System.out.println(subsets.subsets(List.of(1, 2, 3)));
    }
}
