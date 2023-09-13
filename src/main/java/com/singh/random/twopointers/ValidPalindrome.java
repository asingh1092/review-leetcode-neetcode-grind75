package com.singh.random.twopointers;

public class ValidPalindrome {

    public static boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int size = s.length();
        int front = 0;
        int back = size - 1;
        while (front <= back) {
            char fr = s.charAt(front);
            char bk = s.charAt(back);
            boolean frLetter = Character.isLetterOrDigit(fr);
            boolean bkLetter = Character.isLetterOrDigit(bk);
            if (!frLetter) {
                front++;
                continue;
            }
            if (!bkLetter) {
                back--;
                continue;
            }
            if (fr != bk) {
                return false;
            } else {
                front++;
                back--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));
        s = "race a car";
        System.out.println(isPalindrome(s));
    }
}
