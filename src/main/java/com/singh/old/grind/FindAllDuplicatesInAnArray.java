package com.singh.old.grind;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesInAnArray {

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ret = new ArrayList<>();
        int pointer = 0;
        while (pointer < nums.length) {
            int idx = nums[pointer] - 1;
            if (nums[idx] == nums[pointer]) {
                ret.add(nums[pointer]);
                pointer++;
            } else {
                int temp = nums[pointer];
                nums[pointer] = nums[idx];
                nums[idx] = temp;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,3,2,7,8,2,3,1};
        FindAllDuplicatesInAnArray f = new FindAllDuplicatesInAnArray();
        System.out.println(f.findDuplicates(nums));
    }
}
