package com.singh.grind75.week2;

import java.util.*;
public class LongestSubstringWithoutRepeatingCharacters {

    /*
        Given a string s, find the length of the longest substring without repeating characters
        abcabcbb
               ^^
     */
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if (len <= 1) {
            return len;
        }
        int start = 0;
        int end = 0;
        int max = 0;

        Set<Character> set = new HashSet<>();
        char[] arry = s.toCharArray();
        while (end <= len - 1) {
            if (set.contains(arry[end])) {
                start++;
                end = start;
                set.clear();
            } else {
                set.add(arry[end]);
                max = Math.max(max, set.size());
                end++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters l = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(l.lengthOfLongestSubstring("abcabccbb"));
        System.out.println(l.lengthOfLongestSubstring("pwke"));
    }
}
