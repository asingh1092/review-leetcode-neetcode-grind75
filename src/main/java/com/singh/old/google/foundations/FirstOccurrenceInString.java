package com.singh.old.google.foundations;

public class FirstOccurrenceInString {

    /*
            statistics -> a
              ^
            babylon -> a
     */

    public static Character findFirstNonUniqueChar(String s) {
        int[] cache = new int[26];
        for (char c : s.toCharArray()) {
            cache[c - 'a']++;
        }
        for (char c : s.toCharArray()) {
            if (cache[c - 'a'] <= 1) {
                return c;
            }
        }
        return 'f';
    }

    public static void main(String[] args) {
        System.out.println(findFirstNonUniqueChar("statistics"));
        System.out.println(findFirstNonUniqueChar("geeksforgeeks"));
    }
}
