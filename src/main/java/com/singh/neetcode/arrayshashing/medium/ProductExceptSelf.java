package com.singh.neetcode.arrayshashing.medium;

import java.util.Arrays;

public class ProductExceptSelf {

    /*
        Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements
        of nums except nums[i].

        The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer

        You must write an algorithm that runs in O(n) time and without using the division operation.

        Input: nums = [1,2,3,4]
        Output:[24, 12, 8, 6]

        [1, 2, 3, 4]
   i=0   ^  ^
         f  b
        [1, 2, 3, 4]
   i=1   ^     ^
         f     b
        [1, 2, 3, 4]
   i=2      ^     ^
            f     b
        [1, 2, 3, 4]
   i=3         ^  ^
               f  b

        Input: nums = [-1, 1, 0, -3, 3]
        Output: [0, 0, 9, 0, 0]
     */


    /*
        With division operator ????

     */
    public static int[] productExceptSelf(int[] nums) {
        int size = nums.length;
        int[] ret  = new int[size];
        for (int i = 0; i < size; i++) {
            int product = 1;
            int forward = i - 1;
            int backwards = i + 1;
            while (forward >= 0) {
                product = product * nums[forward];
                forward--;
            }
            while (backwards < size) {
                product = product * nums[backwards];
                backwards++;
            }
            ret[i] = product;
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] ex1 = new int[]{1,2,3,4};
        System.out.println(Arrays.toString(productExceptSelf(ex1)));
    }
}
