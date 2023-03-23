package com.singh.neetcode.slidingwindow.medium;

public class LongestRepeatingCharacterReplacement {

    public int characterReplacement(String s, int k) {
        int longest = 0;
        int count = 0;
        int left = 0;
        int right = 0;
        int[] map = new int[26];
        while (right < s.length()) {
            count = Math.max(count, ++map[s.charAt(right) - 'A']);
            while (right - left + 1 - count > k) {
                map[s.charAt(left) - 'A']--;
                left++;
            }
            longest = Math.max(longest, right - left + 1);
            right++;
        }
        return longest;
    }

    public static void main(String[] args) {
        LongestRepeatingCharacterReplacement l = new LongestRepeatingCharacterReplacement();
        System.out.println(l.characterReplacement("ABAB", 2));
        System.out.println(l.characterReplacement("AABABBA", 1));
    }
}
