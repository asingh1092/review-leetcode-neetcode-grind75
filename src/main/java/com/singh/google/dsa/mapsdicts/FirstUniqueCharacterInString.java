package com.singh.google.dsa.mapsdicts;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacterInString {

    public static int firstUniqueChar(String s) {
        // first pass over all chars and add to a map of <Character, Integer (count)>
        Map<Character, Integer> countMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (countMap.containsKey(c)) {
                countMap.put(c, countMap.get(c) + 1);
            } else {
                countMap.put(c, 1);
            }
        }
        // second pass, check to see if Character was only seen once and return else -1
        for (char c : s.toCharArray()) {
            if (countMap.get(c) == 1) {
                return s.indexOf(c);
            }
        }
        return -1;
    }
}
