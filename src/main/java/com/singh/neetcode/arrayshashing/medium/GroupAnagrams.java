package com.singh.neetcode.arrayshashing.medium;

import java.util.*;

public class GroupAnagrams {

    /*
        An anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically
        using all the original letters exactly once.

        [eat, tea, tan, ate, eat, tea] -> [[bat], [nat, tan], [ate, eat, tea]
        "" -> [[""]]
        [a] -> [["a"]]

     Given an array of strings strs, group the anagrams together. You can return the answer in any order.

     */


    /*
        Big O: (O (m* nlogn))
     */
    public List<List<String>> groupAnagramsBRUTE(String[] strs) {
        Map<String, List<String>> map = new TreeMap<>();
        for (String str : strs) {
            char[] ca = str.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }

    /*
        Big O: O(m*n))

     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) {
            return List.of(List.of(""));
        }
        Map<String, List<String>> hMap = new HashMap<>();
        for (String s : strs) {
            int[] count = new int[26];
            char[] chStr = s.toCharArray();
            for (char ch : chStr) {
                count[ch - 'a']++;
            }
            String key = Arrays.toString(count);
            if (!hMap.containsKey(key)) {
                hMap.put(key, new ArrayList<>());
            }
            hMap.get(key).add(s);
        }
        return new ArrayList<>(hMap.values());
    }

    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{""}));
        System.out.println(groupAnagrams(new String[]{"a"}));
        System.out.println(groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));
    }
}
