package com.singh.old.neetcode.arrayshashing.easy;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicates {

    /*
       Given an integer array nums, return true if any value appears at least twice in the array, and return
       false if every element is distinct

        Could use a hashset to see if we have any dups
        Time: O(n) where n is number of integers in nums
        Space: O(n)

       How do we do all this in place????
            Sorting -> n O(log(n))

     */

    public static boolean containsDups(int[] nums) {
        Set<Integer> hSet = new HashSet<Integer>();
        for (int num : nums) {
            if (hSet.contains(num)) {
                return true;
            } else {
                hSet.add(num);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(containsDups(new int[]{1, 2, 3, 1}));
    }

}