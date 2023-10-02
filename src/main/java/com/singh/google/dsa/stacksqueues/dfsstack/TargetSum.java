package com.singh.google.dsa.stacksqueues.dfsstack;

public class TargetSum {

    /*
        1 -> 1 -> 1 -> 1 -> 1

        if (sum == target && used == nums.length) {
            return 1;
        } else {
            // either add next int
            recursive(nums,
            // subtract next int
        }

     */
    // TODO actually a DP problem
    public int targetSum(int[] nums, int target) {
        int ret = 0;
        return recursive(nums, target, 0, 0, ret);
    }

    private int recursive(int[] nums, int target, int sum, int used, int ret) {

        if (sum == target && used == nums.length) {
            return 1;
        }
        if (used == nums.length) {
            return 0;
        }
        int pos = recursive(nums, target, sum + nums[used], used + 1, ret);
        int neg = recursive(nums, target, sum - nums[used], used + 1, ret);
        return pos + neg;
    }
}
