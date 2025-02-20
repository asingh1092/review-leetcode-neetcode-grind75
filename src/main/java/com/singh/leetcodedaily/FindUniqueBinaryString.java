package com.singh.leetcodedaily;

import java.util.ArrayList;
import java.util.List;

public class FindUniqueBinaryString {

    /*
       1. Get length of initial string to know how many binary combos
       2. Create list of





     */
    public String findDifferentBinaryString(String[] nums) {
        List<String> binaries = new ArrayList<>();
        createBinarySet(binaries, new StringBuilder(), nums[0].length());
        for (String num : nums) {
            binaries.remove(num);
        }
        return binaries.get(0);
    }

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

    private void createBinarySet(List<String> list, StringBuilder sb, int max) {
        if (sb.length() == max) {
            list.add(sb.toString());
        } else {

        }
    }

}
