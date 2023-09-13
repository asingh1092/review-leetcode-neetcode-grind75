package com.singh.random.binarysearch;

import java.util.Arrays;
import java.util.List;

public class BinarySearch {

    // Implement binary search
    /*
        Given an array of integers nums which is sorted in ascending order, and an integer target, write
        a function to search target in nums. If target exists, return it's index, else return -1;

           -1, 0, 3, 5, 9, 12 => find 9
            0  1  2  3  4   5
            l        m      h
                        l   h
     */

    public static int search(int[] nums, int target) {
        int size = nums.length;
        int left = 0;
        int right = size - 1;
        int mid;
        while (left <= right) {
            mid = (right - left) / 2 + left;
            if (nums[mid] == target) {
                return mid;
            } else if (target < nums[mid]) {
                // check left side
                right = mid - 1;
            } else {
                // check right side
                left = mid + 1;
            }
        }
        return -1;
    }
}
