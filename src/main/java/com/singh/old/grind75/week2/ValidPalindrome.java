package com.singh.old.grind75.week2;

public class ValidPalindrome {

    /*
        A man, a plan, a canal: Panama
        ^                           ^

     */
    public boolean isValid(String s) {
        int start = 0;
        int end = s.length() - 1;
        char[] ca = s.toCharArray();
        while (start < end) {
            char st = ca[start];
            char en = ca[end];
            if (!Character.isLetterOrDigit(st)) {
                start++;
            } else if(!Character.isLetterOrDigit(en)) {
                end--;
            } else {
                if (Character.toLowerCase(st) == Character.toLowerCase(en)) {
                    start++;
                    end--;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
