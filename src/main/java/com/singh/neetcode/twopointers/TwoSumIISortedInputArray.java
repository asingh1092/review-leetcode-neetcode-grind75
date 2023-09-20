package com.singh.neetcode.twopointers;

import java.util.Arrays;

public class TwoSumIISortedInputArray {

    /*
        Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers
        such that they add up to a specific target number.

        Let these two numbers be numbers[index_1] where 1 <= index_1 <= index_2 <= numbers.length.

        Return the indices of the two numbers, index_1 and index_2, added by one as an integer array [index1, index2] of length 2.

        The tests are generated such that there is exactly one solution. You may not use the same element twice.

        Your solution must use only constant extra space - O(1).

        E.g.
             numbers = [2,7,11,15] target = 9 -> [1,2]
             numbers = [2,3,4] target = 6 -> [1,3]
             numbers = [-1,0] target = -1 -> [1,2]

     */

    // leverage the numbers being sorted
    public int[] twoSum(int[] numbers, int target) {
        int[] ret = new int[2];
        int first = 0;
        int second = numbers.length - 1;
        if (numbers == null || numbers.length < 2) {
            return ret;
        }
        while (first < second) {
            int value = numbers[first] + numbers[second];
            if (target == value) {
                ret[0] = first + 1;
                ret[1] = second + 1;
                break;
            } else if (value > target) {
                second--;
            } else {
                first++;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        TwoSumIISortedInputArray twoSum = new TwoSumIISortedInputArray();
        System.out.println(Arrays.toString(twoSum.twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(twoSum.twoSum(new int[]{2,3,4}, 6)));
        System.out.println(Arrays.toString(twoSum.twoSum(new int[]{-1, 0}, -1)));

    }
}
