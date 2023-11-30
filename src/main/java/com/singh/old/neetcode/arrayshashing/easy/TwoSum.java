package com.singh.old.neetcode.arrayshashing.easy;

public class TwoSum {


    public static int[] twoSumWrong(int[] input, int target) {
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

    // correct answer
    public int[] twoSum(int[] numbers, int target) {
        int[] ret = new int[2];
        int first = 0;
        int second = numbers.length - 1;
        if (numbers.length < 2) {
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

}
