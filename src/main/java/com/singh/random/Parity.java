package com.singh.random;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Parity {

    /*
        [3, 1, 2, 4] ->
         ^     ^

     */
    public static int[] sortArrayByParity(int[] nums) {
        int even = 0;
        int odd = nums.length - 1;
        while (even < odd) {
            if (nums[even] % 2 == 0) {
                even++;
            } else {
                // swap
                int temp = nums[odd];
                nums[odd] = nums[even];
                nums[even] = temp;
                odd--;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] input = new int[]{3, 1, 2, 4};
        System.out.println(Arrays.toString(sortArrayByParity(input)));
    }
}
