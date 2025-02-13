package com.singh.old.grind75.week2;

import java.util.*;
public class MinimumWindowSubstring {

    /*
        Given two strings s, and t, of lengths m and n respectively, return the minimum window substring of s such that
        every character in t (including dups) is included in the window. If there is no such substring, return the
        empty string ""

        The test cases will be generated such that the answer is unique.

        E.G
        "ADOBECODEBANC" "ABC"

        "BANC"

     */

    public String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }

        // first create freq map of t
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : t.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        Map<Character, Integer> temp = new HashMap<>(freq); // copy
        // now make a sliding window over s
        int min_start = 0;
        int min_end = 0;
        int min = 0;

        int start = 0;
        int end = 0;
        char[] arr = s.toCharArray();
        while (end <= arr.length - 1) {
            char c = arr[end];
            if (temp.containsKey(c) && temp.get(c) > 0) {
                temp.put(c, temp.get(c) - 1);
                if (temp.isEmpty()) {
                    min = Math.min(min, temp.size());
                    start++;
                    end = start;
                    temp = new HashMap<>(freq);
                } else {
                    end++;
                }
            } else {
                start++;
                end = start;
                temp = new HashMap<>(freq); // copy
            }
        }

        return min > 0 ? s.substring(min_start, min_end) : "";
    }
}
