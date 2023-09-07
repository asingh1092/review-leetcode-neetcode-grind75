package com.singh.google.dsa.mapsdicts.keydesign;

import java.util.*;

public class GroupAnagrams {

    /*
        each letter has a integer value so add them up to equal some key then add the word to its list which is the value

     */

    public static List<List<String>> anagrams(String[] strs) {
        // Map of <Key (chars), List<Words>>
        Map<String, List<String>> map = new HashMap<>();
        for (String word : strs) {
            char[] ca = new char[26];
            for (char c : word.toCharArray()) {
                ca[c - 'a']++;
            }
            String key = String.valueOf(ca);

            List<String> list;
            if (map.containsKey(key)) {
                list = map.get(key);
            } else {
                list = new ArrayList<>();
            }
            list.add(word);
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan","ate", "nat", "bat"};
        String[] strs2 = {"cab","tin","pew","duh","may","ill","buy","bar","max","doc"};
        System.out.println(anagrams(strs2));
    }
}
