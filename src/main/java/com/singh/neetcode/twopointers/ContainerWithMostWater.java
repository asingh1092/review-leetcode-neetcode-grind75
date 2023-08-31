package com.singh.neetcode.twopointers;

public class ContainerWithMostWater {
    /*
        Given an integer array height of length n.
        There are n vertical lines drawn such that the two endpoints of the ith line are (i,0) and (i, height[i]).

        Find two lines that together with the x-axis form a container, such that the container contains the most water.

        Return the maximum amount of water a container can store: NO SLANT CONTAINERS

        [ 1, 8, 6, 2, 5, 4, 8, 3, 7 ]


        Brute force approach: calculate every area and spit out the max
        Space: O(1)
        Time: O(n+(n-1)+(n-2)+(n-3)..+ 1)) = n*(n-1)/2 = n^2

        Proof:
            1. The widest container (using first and last line) is a good candidate, because of its width.
                Its water level is the height of the smaller one of first and last line.
            2. All other containers are less wide and thus would need a higher water level in order to hold more water.
            3. The smaller one of first and last line doesn't support a higher water level and can thus be safely
                removed from further consideration.
     */

    public static int maxWaterinContainer(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int ret = 0;
        while (left < right) {
            int diff = right - left;
            int min = Math.min(height[left], height[right]);
            ret = Math.max(ret, min * diff);
            if (height[left] == min) {
                left++;
            } else
                right--;
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(maxWaterinContainer(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }
}
