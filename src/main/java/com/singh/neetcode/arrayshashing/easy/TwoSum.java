package com.singh.neetcode.arrayshashing.easy;

public class TwoSum {


    public static int[] twoSum(int[] input, int target) {
        int i = 0;
        int j = 1;
        int[] ret = new int[]{i, j};
        while (i != input.length - 1) {
            if (target - input[j] == input[i]) {
                return new int[]{i, j};
            } else {
                if (j == input.length - 1) {
                    i++;
                    j = i + 1;
                } else {
                    j++;
                }
            }
        }
        return ret;
    }
}
