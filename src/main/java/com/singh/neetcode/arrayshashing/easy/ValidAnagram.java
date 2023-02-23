package com.singh.neetcode.arrayshashing.easy;

import java.util.Arrays;

public class ValidAnagram {

    /*
       Given two strings s and T, return true if t is an anagram of s, and false otherwise.

       An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
       typically using all the original letters exactly once.

       Base case -> same length
       1. String -> char arrays -> sort -> iterate over
       2. int[26]

     */
    public boolean isAnagram(String s, String t) {
        int s_length = s.length();
        int t_length = t.length();
        if (s_length != t_length) {
            return false;
        }

        int[] map = new int[26];

        for (int i = 0; i <= s_length - 1; i++) {
            map[s.charAt(i) - 'a']++;
            map[t.charAt(i) - 'a']--;
        }

        for (int n : map) {
            if (n != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAnagramCollectionsSort(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] s_array = s.toCharArray();
        char[] t_array = t.toCharArray();
        Arrays.sort(s_array);
        Arrays.sort(t_array);
        for (int i = 0; i <= s.length() - 1; i++) {
            if (s_array[i] != t_array[i]) {
                return false;
            }
        }
        return true;
    }







    public static void main(String[] args) {
        System.out.println(isAnagramCollectionsSort("a", "b"));
    }

    public static boolean isValidAnagramP2(String first, String second) {
        int firstLength = first.length();
        int secondLength = second.length();
        if (firstLength != secondLength) {
            return false;
        }
        int[] map = new int[26];

        for (int i = 0; i <= firstLength - 1; i++) {
            map[first.charAt(i) - 'a']++;
            map[second.charAt(i) - 'a']--;
        }

        for (int value : map) {
            if (value != 0) {
                return false;
            }
        }
        return true;
    }
}
