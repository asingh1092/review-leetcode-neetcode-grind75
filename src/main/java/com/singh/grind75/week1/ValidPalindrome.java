package com.singh.grind75.week1;

import java.util.Locale;

public class ValidPalindrome {

    public static boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        char[] ca = s.toLowerCase().toCharArray();
        while (start < end) {
            if (!Character.isLetterOrDigit(ca[start])) {
                start++;
            } else if (!Character.isLetterOrDigit(ca[end])) {
                end--;
            } else if (ca[start] != ca[end]) {
                return false;
            } else {
                start++;
                end--;
            }
        }
        return true;
    }
}
