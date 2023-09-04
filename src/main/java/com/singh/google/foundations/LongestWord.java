package com.singh.google.foundations;

import java.util.ArrayList;
import java.util.List;

public class LongestWord {

    public static String findLongestWordinString(String sen) {
        List<String> words = new ArrayList<>();
        char[] cArray = sen.toCharArray();
        int begin = 0;
        int end = 0;
        for (char c : cArray) {
             if (Character.isAlphabetic(c)) {
                 end++;
             } else {
                 words.add(sen.substring(begin, end));
                 begin = end + 1;
                 end = begin;
             }
        }
        words.add(sen.substring(begin, end));

        int longestIndex = 0;
        int pointer = 0;
        int max = 0;
        for (String word : words) {
            if (word.length() > max) {
                max = word.length();
                longestIndex = pointer;
            }
            pointer++;
        }
        return words.get(longestIndex);
    }

    public static void main(String[] args) {
        System.out.println(findLongestWordinString("fun&!! time"));
        System.out.println(findLongestWordinString("I love dogs"));
    }
}
