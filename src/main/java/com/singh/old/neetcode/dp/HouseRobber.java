package com.singh.old.neetcode.dp;

import java.util.Arrays;

public class HouseRobber {

    /*
        You are a professional robber planning to rob houses along a street. Each house has a certain amount of money
        stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected
        and will automatically call the police of two adjacent houses were broken into the same night

        Given an integer array nums representing the amount of money of each house, return the maximum amount of money
        you can rob tonight without alerting the police.

        nums = [1,2,3,1]           1  3  => 4
                                   2  1  => 3
                                   3    =>  3
                                   1    =>  1

               [2,7,9,3,1]        2  9  1  => 12
                                  7  3     => 10
                                  9  1     => 10
                                  3        =>  3
                                  1
            nums = [1,2]
            nums = [1]

            rob(0 houses) = 0
            rob(1 house) = rob(1)
            rob(2 house) = max[rob(1), rob(2)]
            rob(3 house) = max[rob(3) + rob (1), rob(2)]
            rob(n house) = max[rob(n) + rob(n-2), rob(n-1)]
     */

    public int rob(int[] nums) {
        return recursive(nums, nums.length - 1);
    }

    private int recursive(int[] nums, int n) {
        //base case
        if (n < 0) {
            return 0;
        }

        return Math.max(recursive(nums, n - 2) + nums[n], recursive(nums, n - 1));
    }


    private int robTopDown(int[] nums) {
        int[] memo = new int[nums.length + 1];
        Arrays.fill(memo, -1);
        return topDown(nums, nums.length - 1, memo);
    }

    /*
       memo[0] = 0
       memo[1] = rob(1)
       memo[2] = max[rob(1), rob(2)]
       memo[3] = max[rob(3) + rob(1), rob(2)]
       memo[n] = max[rob(n) + rob(n-2), rob(n-1)]
    */
    private int topDown(int[] nums, int n, int[] memo) {
        if (n < 0) {
            return 0;
        }
        if (memo[n] != -1) {
            return memo[n];
        }
        memo[n] = Math.max(topDown(nums, n - 2, memo) + nums[n], topDown(nums, n - 1, memo));
        return memo[n];
    }

    public int robBottomUp(int[] nums) {
        // base cases
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        int[] memo = new int[nums.length + 1];
        memo[0] = 0;
        memo[1] = nums[0];
        for (int n = 2; n < nums.length; n++) {
            memo[n] = Math.max(memo[n - 2] + nums[n], memo[n - 1]);
        }
        return memo[nums.length];
    }

    public static void main(String[] args) {
        HouseRobber rob = new HouseRobber();
        System.out.println(rob.rob(new int[]{1,2,3,1}));
        System.out.println(rob.rob(new int[]{2,7,9,3,1}));
        System.out.println(rob.robTopDown(new int[]{1,2,3,1}));
        System.out.println(rob.robTopDown(new int[]{2,7,9,3,1}));
        System.out.println(rob.robBottomUp(new int[]{1,2,3,1}));
        System.out.println(rob.robBottomUp(new int[]{2,7,9,3,1}));
    }
}
