package com.singh.old.neetcode.slidingwindow.medium;

public class PermutationInString {

    /*
        Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise

        In other words, return true if one of s1's permutations is the substring of s2.

        e.g. s1 = "ab", s2 = "eidbaooo" -> true
                              ^
                              ^
             s1 = "ab", s2 = "eidboaoo" -> false

        // add all of s1 into some sort of cache and then pop and remove items as we go down


     */
    public boolean checkInclusion(String s1, String s2) {
        int[] s1Map = new int[26];
        int[] s2Map = new int[26];

        for (char c : s1.toCharArray()) {
            s1Map[c - 'a']++;
        }
        char[] s2_char = s2.toCharArray();
        int left = 0;
        int right = 1;
        while (right > s2.length()) {

        }
        return false;
    }
}
