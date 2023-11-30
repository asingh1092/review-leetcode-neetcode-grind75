package com.singh.old.neetcode.slidingwindow.medium;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        int longest = 0;
        Set<Character> hSet = new HashSet<>();
        int left = 0;
        int right = 0;
        while (right < s.length()) {
            if (hSet.contains(s.charAt(right))) {
                hSet.remove(s.charAt(left));
                left++;
            } else {
                hSet.add(s.charAt(right));
                right++;
                longest = Math.max(longest, hSet.size());
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        int[] chars = new int[26];
        if (chars[s.charAt(0) - 'a'] == 0) {
            // we know that there is no char
            chars[s.charAt(0) - 'a']++;
        }
    }
}
