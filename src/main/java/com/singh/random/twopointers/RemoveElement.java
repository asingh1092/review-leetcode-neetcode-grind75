package com.singh.random.twopointers;

public class RemoveElement {
    /*
        Given an integer array nums and integer val, remove all occurrences of val in nums IN-PLACE.
        The order of the elements may be changed, then return the number of elements in nums which is not equal to val.


        nums - [3, 2, 2, 3] val = 3
                ^        ^
               [3, 2, 2, 3]
                ^     ^
               [2, 2, 3, 3]
                ^  ^
               [2, 2, 3, 3]
                      ^
                   ^
     */

    public static int removeElement(int[] nums, int val) {
        int size = nums.length;
        int ret = 0;
        int front = 0;
        int back = size - 1;
        while (front <= back) {
            if (nums[front] == val) {
                swap(nums, front, back);
                back--;
            } else {
                ret++;
                front++;
            }
        }
        return ret;
    }

    private static void swap(int[] nums, int front, int back) {
        int temp = nums[back];
        nums[back] = nums[front];
        nums[front] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 2, 3};
        int val = 3;
        System.out.println(removeElement(nums, val));
        nums = new int[]{0,1,2,2,3,0,4,2};
        val = 2;
        System.out.println(removeElement(nums, val));
    }
}
