package com.singh.grind75.week1;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicates {

    public boolean containsDuplicates(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            if (set.contains(n)) {
                return true;
            } else {
                set.add(n);
            }
        }
        return false;
    }
}
