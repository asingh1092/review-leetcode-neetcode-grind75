package com.singh.neetcode.binarysearch;

public class KokoEatingBananas {

    /*
        There are [n] piles of bananas, where the [ith] pile has [piles[i]] bananas

        The guards have gone and will come back in [h] hours
        Koko can eat bananas/hour seating speed of k.
        Each hour she chooses some pile of bananas and eats k bananas from that pile
        if pile has < k bananas, she eats them all instead and will not eat anymore bananas during this hour

        Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return

        Return the minimum integer k such that she can eat all the bananas within h hours

        [3,6,7,11] h = 8
         1 2 2 3

        [4,11,20,23,30] h = 5, h = 6
         1 1  1  2  2

         find max, then do binary search to find some k such that iterating over all the piles equals h
     */

    public static int minEatingSpeed(int[] piles, int h) {
//        int size = piles.length;
//        int low = 0;
//        int high = size - 1;
//        Arrays.sort(piles);
//        while (low <= high) {
//            int mid = (high - low) / 2 + low;
//            int k = piles[mid];
//            int hForK = 0;
//            for (int pile : piles) {
//                 // hForK += Math.ceilDiv(pile, k);
//                hForK += (int) Math.ceil((double)pile/k);
//            }
//            if (high - low <= 1) {
//                // check inbetween these two indices
//                int lower = piles[low];
//                int higher = piles[high];
//                while (lower <= higher) {
//                    k = lower;
//                    hForK = 0;
//                    for (int pile : piles) {
//                        // hForK += Math.ceilDiv(pile, k);
//                        hForK += (int) Math.ceil((double)pile/k);
//                    }
//                    if (hForK == h) {
//                        return k;
//                    } else {
//                        lower++;
//                    }
//                }
//                return -1;
//            } else if (hForK > h) {
//                low = mid;
//            } else {
//                high = mid;
//            }
//        }
//        return -1;

        // first find max;
        int maxK = 1;
        for (int pile : piles) {
            maxK = Math.max(pile, maxK);
        }

        // do binary search over 1 to k
        int low = 1;
        int high = maxK;
        int res = high;
        while (low <= high) {
            int k = (high - low) / 2 + low;
            int hours = 0;
            for (int pile : piles) {
                // hForK += Math.ceilDiv(pile, k);
                hours += (int) Math.ceil((double) pile / k);
            }
            if (hours <= h) {
                res = Math.min(res, k);
                high = k - 1;
            } else {
                low = low + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(minEatingSpeed(new int[]{3, 6, 7, 11}, 8));
        System.out.println(minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 5));
        System.out.println(minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 6));
        System.out.println(minEatingSpeed(new int[]{312884470}, 312884469));
    }
}
