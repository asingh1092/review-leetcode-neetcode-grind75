package com.singh.google.foundations;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CollectionOfNumbers {

    /*
        [1, 2, 3, 9] -> target = 8

        [1, 2, 4, 4] -> target = 8

        what do I do if there is no pair that equals the target?
        find nums or indices?
        is the collection sorted?

        HashMap<Integer (Number), Integer (Index)> cache;
     */

    public static int[] twoSum(int[] input, int target) {
        Map<Integer, Integer> cache = new HashMap<>();
        for (int i = 0; i < input.length; i++) {
            int value = target - input[i];
            if (cache.containsKey(value)) {
                return new int[]{input[i], value};
            } else {
                cache.put(input[i], i);
            }
        }
        return new int[]{0, 0};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{1, 2, 4, 4}, 8)));
        System.out.println(Arrays.toString(twoSum(new int[]{1, 2, 4, 9}, 8)));
    }
}
