package com.singh.grind75.week2;

public class ContainerWithTheMostWater {

    /*
        Given an integer array [height] of length [n], there are [n] vertical lines
        such that the two endpoints of the ith line are (i, 0) and (i, height[i])


        0 1 2 3 4 5 6 7 8
        1 8 6 2 5 4 8 3 7
        ^               ^
        0 1 2 3 4 5 6 7 8
        1 2 3 4 5 6 7 8 9
        ^   ^
        max so far =
        1*1 = 1
        2*1 = 2
        6*1 = 6

     */
    public int maxArea(int[] height) {
        int max = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int min = Math.min(height[left], height[right]);
            max = Math.max(max, (min * (right - left)));
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new ContainerWithTheMostWater().maxArea(new int[]{1, 1}));
        System.out.println(new ContainerWithTheMostWater().maxArea(new int[]{1,8,6,2,5,4,8,3,7 }));
    }

}
