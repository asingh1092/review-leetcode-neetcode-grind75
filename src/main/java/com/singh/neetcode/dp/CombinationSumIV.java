package com.singh.neetcode.dp;

import java.util.Arrays;

public class CombinationSumIV {

    /*
        Given an array of numbers nums and a target number target, return the number of combinations that add to the target

        target = 4
        nums = [1, 2, 3]
        ret => 7
                                1                          2                                3
                         1      2       3
              1   2    3     1  2  3   1    2   3
          1
     [1,1,1,1]



            [1,1,1,1], [1,1,2], [1,2,1], [1,3]          [2,1,1], [2,2],       [3,1]

            What do we want: all combinations that add up to target
            What do we want recursively: c(n) = x*n[0] + y*n[1] + z*n[2] + .......b*n[n-1] + a*n[n]
            Base case: if we get a sum of target, add one to ret
     */


    public int combinationSum4(int[] nums, int target) {
        // base case
        if (target < 0) {
            return 0;
        }
        if (target == 0) {
            return 1;
        }

        // recurse
        int ret = 0;
        for (int num : nums) {
            ret += combinationSum4(nums, target - num);
        }
        return ret;
    }

    public int combinationSum4TopDown(int[] nums, int target) {
        int[] memo = new int[target + 1];
        memo[0] = 1;
        for (int i = 1; i <= target; i++)
            for (int num : nums)
                if (num <= i) {
                    memo[i] += memo[i - num];
                }
        return memo[target];
    }

    private int[] dp;

    public int combinationSum4TopDown2(int[] nums, int target) {
        dp = new int[target + 1];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        return helper(nums, target);
    }

    private int helper(int[] nums, int target) {
        if (dp[target] != -1) {
            return dp[target];
        }
        int res = 0;
        for (int num : nums) {
            if (target >= num) {
                res += helper(nums, target - num);
            }
        }
        dp[target] = res;
        return res;
    }

    // TODO Bottom up approach
}
