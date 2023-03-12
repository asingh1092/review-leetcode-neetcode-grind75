package com.singh.neetcode.binarysearch;

import java.util.Arrays;
import java.util.Collections;

public class BinarySearch {

    /*
        Given an array of integers nums which is sorted in ascending order, and an integer target, write a function
        to search target in nums, if target exists then return its index, otherwise return -1.

        You must write an algorithm with O(logn) runtime complexity.

        [-1, 0, 3, 5, 9, 12] target = 12
                ^
                  [        ]
                  [5, 9, 12]
                      ^
                        [12]
                          ^  return index of 12
        [-1, 0, 3, 5, 9, 12] target = 2
                ^
        [-1 0]
          ^
         [0]
          ^   return -1
     */

   public int searchCheatingWay(int[] nums, int target) {
       int ret = Arrays.binarySearch(nums, target);
       return ret < 0 ? -1 : ret;
   }

   public int search(int nums[], int target) {
       int mid;
       int low = 0;
       int high = nums.length - 1;
       while (low <= high) {
           mid = (high - low) / 2 + low;
           if (nums[mid] == target) {
               return mid;
           } else if (target > nums[mid]) {
               low = mid + 1;
           } else {
               high = mid - 1;
           }
       }
       return -1;
   }
}
