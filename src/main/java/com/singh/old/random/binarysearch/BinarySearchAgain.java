package com.singh.old.random.binarysearch;

public class BinarySearchAgain {

    /*

        [1,4, 6, 7, 10, 14]   target = 8
                    ^
        [1]
         ^
         ^
     */
    public int search(int[] nums, int target) {
        int size = nums.length;
        int low = 0;
        int high = size - 1;
        while (low <= high) {
            int mid = (high - low) / 2  + low;
            int value = nums[mid];
            if (value == target) {
                return mid;
            } else if (value > mid) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 4, 6, 7, 10, 14};
        BinarySearchAgain s = new BinarySearchAgain();
        System.out.println(s.search(nums, 8));
        System.out.println(s.search(nums, 10));
        System.out.println(s.search(nums, 14));
        System.out.println(s.search(new int[]{1}, 4));
    }
}
