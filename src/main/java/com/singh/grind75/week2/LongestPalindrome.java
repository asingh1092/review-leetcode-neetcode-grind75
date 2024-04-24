package com.singh.grind75.week2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestPalindrome {

    /*
        abccccdd

        a 1
        b 1
        c 4
        d 2

        a
        a 1

        aaccccdde
        a 2
        c 4
        d 2
        e 1

        bananas
        a 3
        b 1
        n 2
        s 1
     */

    public int longestPalindome(String s) {
        int len = s.length();
        int max = 0;
        if (len == 0) {
            return max;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        boolean oddFlag = false;
        for (int i : map.values()) {
            if (i % 2 == 0) {
                max += i;
            } else {
                oddFlag = true;
                max += i  - 1;
            }
        }
        return oddFlag ? max + 1 : max;
    }

    public static void main(String[] args) {
        LongestPalindrome lp = new LongestPalindrome();
        System.out.println(lp.longestPalindome("abccccdd"));
        System.out.println(lp.longestPalindome("abccccdde"));
        System.out.println(lp.longestPalindome("a"));
        System.out.println(lp.longestPalindome(""));
        System.out.println(lp.longestPalindome("aaccccdd"));
        System.out.println(lp.longestPalindome("ccc"));
        System.out.println(lp.longestPalindome("bananas"));
        System.out.println(lp.longestPalindome("AAA"));
    }
}
