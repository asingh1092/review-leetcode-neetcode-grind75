package com.singh.google.dsa.mapsdicts.hashset;

import java.util.HashSet;

public class HappyNumber {
    /*
        Check if n is happy

        A happy number is defined by the following process:
            * Starting with any positive integer, replace the number by the sum of the square of its digits
            * Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
            * Those numbers for which this process ends in 1 are happy
            * If we've seen the sum before, return false.

       Return true if n is a happy number, else false.
       19

     */

    public static boolean isHappy(int n) {

        HashSet<Integer> st = new HashSet<>();
        while (true) {
            n = numSquareSum(n);
            if (n == 1)
                return true;
            if (st.contains(n))
                return false;
            st.add(n);
        }
    }

    private static int numSquareSum(int n) {
        int squareSum = 0;
        while (n != 0) {
            int root = n % 10;
            squareSum += root * root;
            n /= 10;
        }
        return squareSum;
    }
}
