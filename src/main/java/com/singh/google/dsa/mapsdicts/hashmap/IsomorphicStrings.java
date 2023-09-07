package com.singh.google.dsa.mapsdicts.hashmap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class IsomorphicStrings {

    /*
        Two strings s and t are isomorphic if the characters in s can be replaced to get t.

        All occurrences of a character must be replaced with another charter while preserving the order of characters
        No two characters may map to the same character, but a character may map to itself.

        e.g. s = egg, t = add
            e g g
            0 1 2

            0 1
            1 2
            2 2

            0 1
            1 2
            2 2

            a d d
            0 1 2

            f o o

            0  1
            1  2
            2  2

            0  1
            1  2
            2  3

            b a r

            paper
            12134
            title
            12134

     */
    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();
        int next1 = 1;
        int next2 = 1;
        for (char c : s.toCharArray()) {
            if (map1.containsKey(next1)) {
                next1++;
            } else {
                map1.put(next1, s.indexOf(c));
                next1++;
            }
        }
        for (char c : t.toCharArray()) {
            if (map2.containsKey(next2)) {
                next2++;
            } else {
                map2.put(next2, t.indexOf(c));
                next2++;
            }
        }
        for (int i = 1; i <= map1.size(); i++) {
            if (!Objects.equals(map1.get(i), map2.get(i))) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String s = "foo";
        String t = "bar";
        System.out.println(isIsomorphic(s, t));
    }
}
