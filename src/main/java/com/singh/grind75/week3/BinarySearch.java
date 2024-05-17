package com.singh.grind75.week3;

public class BinarySearch {

    /*
        1 2 3 4 5 6 7 8 9 10



     */
    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return  -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = ((right - left) / 2) + left;
            if (nums[mid] == target) {
                return mid;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
