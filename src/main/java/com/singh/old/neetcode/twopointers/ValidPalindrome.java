package com.singh.old.neetcode.twopointers;

public class ValidPalindrome {
    /*
         A phrase is a palindrome if, after converting all uppercase letters into lowercase letters
         and removing all non-alphanumeric characters, it reads the same forward and backward.

         Alphanumeric characters include letters and numbers

         Given a string s, return true if it is a palindrome, or false otherwise.

         e.g. "A man, a plan, a canal: Panama"
               "amanaplanacanalpanama? -> true

              "race a car"
                  ^ ^
              " "
               ^
     */

    public boolean isPalindrome(String str) {
        int beginIdx = 0;
        int endIdx = str.length() - 1;
        char[] chars = str.toCharArray();
        while (beginIdx <= endIdx) {
            if (!Character.isLetterOrDigit(chars[beginIdx])) {
                beginIdx++;
                continue;
            }
            if (!Character.isLetterOrDigit(chars[endIdx])) {
                endIdx--;
                continue;
            }
            if (Character.toLowerCase(chars[beginIdx]) != Character.toLowerCase(chars[endIdx])) {
                return false;
            } else {
                beginIdx++;
                endIdx--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidPalindrome validPalindrome = new ValidPalindrome();
        System.out.println(validPalindrome.isPalindrome(" "));
        System.out.println(validPalindrome.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(validPalindrome.isPalindrome("race a car"));
    }
}
