package com.singh.leetcode;

public class FindTheOriginalArrayOfPrefixXor {

    /*
        pref[0] = 5
        pref[1] = 5 ^ 7 = 2
        pref[2] = 5 ^ 7 ^ 2 = 0
        pref[3] = 5 ^ 7 ^ 2 ^ 0 = 3
        pref[4] = 5 ^ 7 ^ 2 ^ 0 ^ 3 = 1

        if a ^ b = c and a ^ c = b then b ^ c = a
     */

    public int[] findArray(int[] pref) {
        for (int i = pref.length - 1; i > 0; i--) {
            pref[i] ^= pref[i - 1];
        }
        return pref;
    }
}
