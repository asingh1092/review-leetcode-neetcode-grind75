package com.singh.google.dsa.mapsdicts.hashset;

import java.util.*;


public class IntersectionOfTwoArrays {

    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> hSet1 = new HashSet<>();
        Set<Integer> hSet2 = new HashSet<>();
        for (int i : nums1) {
            hSet1.add(i);
        }
        for (int j : nums2) {
            hSet2.add(j);
        }
        List<Integer> ret = new ArrayList<>();
        if (hSet1.size() >= hSet2.size()) {
            for (int k : hSet1) {
                if (hSet2.contains(k)) {
                    ret.add(k);
                }
            }
        } else {
            for (int k : hSet2) {
                if (hSet1.contains(k)) {
                    ret.add(k);
                }
            }
        }
        int pointer = 0;
        int[] actualRet = new int[ret.size()];
        for (int z : ret) {
            actualRet[pointer] = z;
            pointer++;
        }
        return actualRet;
    }

    public static void main(String[] args) {
//        int[] nums1 = new int[]{1, 2, 2, 1};
//        int[] nums2 = new int[]{2, 2};
        int[] nums1 = new int[]{4, 9, 5};
        int[] nums2 = new int[]{9, 4, 9, 8, 4};
        System.out.println(Arrays.toString(intersection(nums1, nums2)));
    }
}
