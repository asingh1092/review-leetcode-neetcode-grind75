package com.singh.old.grind75.week1;

import java.util.Arrays;
import java.util.Collections;

public class SortColors {

    /*
        0 0 0 1 2 2
     r      ^
     w      ^
     b        ^
       1 0 2
     r ^
     w ^
     b   ^
     */

    public void sortColors(int[] nums) {
        if (nums.length == 0) {
            return;
        }
        int redPos = 0;
        int whitePos = 0;
        int bluePos = nums.length - 1;
        while (whitePos <= bluePos) {
            if (nums[whitePos] == 0) {
                swap(nums, redPos, whitePos);
                redPos++;
                whitePos++;
            } else if (nums[whitePos] == 1) {
                whitePos++;
            } else {
                swap(nums, whitePos, bluePos);
                bluePos--;
            }
        }
    }

    public void swap(int[] list, int a, int b) {
        int temp = list[a];
        list[a] = list[b];
        list[b] = temp;
    }

}
