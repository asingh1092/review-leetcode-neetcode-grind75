package com.singh.google.dsa.mapsdicts.hashmap;

import java.util.*;

public class MinimumIndexSumOfTwoStrings {

    /*
        Given two arrays of strings list1 and list2, find the common strings with the least index sum.

        A common string is a string that appeared in both list1 and list 2
        A common string with the least index sum is a common string such that if it appeared at list1[i] and list2[j]
        then i + j should be the minimum value among all the other common strings.

        Return all the common strings with the least index sum. Return the answer in any order.

        # See which words are the same in each list and note their indices.
        # Find least index sum between same words
        # add to string array or convert to string array

        list1 -> o(n)
        Map<Word, indices>
        Map<Word, Indices>
        Set<Word> ->
        ret = String[]
     */

    public static String[] indexSum(String[] list1, String[] list2) {
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        Set<String> set = new HashSet<>();
        int pointer = 0;
        for (String word : list1) {
            map1.put(word, pointer);
            set.add(word);
            pointer++;
        }
        pointer = 0;
        for (String word : list2) {
            if (set.contains(word)) {
                map2.put(word, pointer + map1.get(word));
            }
            pointer++;
        }

        List<String> almostRet = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for (Map.Entry<String, Integer> entry : map2.entrySet()) {
            if (entry.getValue() == min) {
                almostRet.add(entry.getKey());
            }
            if (entry.getValue() < min) {
                almostRet.clear();
                min = entry.getValue();
                almostRet.add(entry.getKey());
            }
        }

        String[] ret = new String[almostRet.size()];
        for (int i = 0; i < almostRet.size(); i++) {
            ret[i] = almostRet.get(i);
        }

        return ret;
    }

    public static void main(String[] args) {
        String[] list1 = {"Shogun","Tapioca Express","Burger King","KFC"};
        String[] list2 = {"KFC","Shogun","Burger King"};
        System.out.println(Arrays.toString(indexSum(list1, list2)));
    }
}
