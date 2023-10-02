package com.singh.neetcode.dp;

import java.util.Arrays;

public class ZeroOneKnapsack {

    /*
        Given two integer arrays to represent weights and profits of N items,
        we need to find a subset of those items which will give us maximum profits
        such that their cumulative weight is not more than a given number C.

        Write a function that returns the maximum profit.

        Each item can only be selected once, which means either we put an item in the knapsack or skip it

        DP! top-down approach (memoization) or bottom-up (tabulation)

         capacity = 3                       1    2   3   5
         profits: 1  6   10  16          1                            weight[n] + weight[n-1] ...... + weight[0] =< capacity
        weights: 1  2   3   5            6
                                         10                 -> 17
                                         16                 -> 22

                                         1               2               3             5
                                   2     3    5     1   3   5         1  2  5       1   2    3
                               3   x   2  5   x
                             x         x

                 c(n) = xw[0] + yw[1] + zw[2] .... aw[n - 1] +


        for each item 'i'
          create a new set which INCLUDES item 'i' if the total weight does not exceed the capacity, and
             recursively process the remaining capacity and items
          create a new set WITHOUT item 'i', and recursively process the remaining items
        return the set from the above two sets with higher profit
     */
    public int solveKnapsackRecursive(int[] profits, int[] weights, int capacity) {
        return dp(profits, weights, capacity, 0);
    }

    public int dp(int[] profits, int[] weights, int capacity, int currentIdx) {
        // base check
        if (capacity <= 0 || currentIdx >= profits.length) {
            return 0;
        }

        // recursive call with item at current idx; if weight DOES NOT exceed capacity
        int profit1 = 0;
        if (weights[currentIdx] <= capacity) {
            profit1 = profits[currentIdx] + dp(profits, weights, capacity - weights[currentIdx], currentIdx + 1);
        }

        // Skip this item: recursive call without item at current idx
        int profit2 = dp(profits, weights, capacity, currentIdx + 1);

        return Math.max(profit1, profit2);
    }

    public int[][] memo;

    public int solveKnapsackTopDown(int[] profits, int[] weights, int capacity) {
        memo = new int[profits.length][capacity + 1];
        for (int[] n : memo) {
            Arrays.fill(n, -1);
        }
        return dp(profits, weights, capacity, 0);
    }

    public int dpTopDown(int[] profits, int[] weights, int capacity, int currentIdx) {
        // base check
        if (capacity <= 0 || currentIdx >= profits.length) {
            return 0;
        }

        // if we have already solved a similar problem, return the result from memory
        if (memo[currentIdx][capacity] != -1) {
            return memo[currentIdx][capacity];
        }

        // recursive call with item at current idx; if weight DOES NOT exceed capacity
        int profit1 = 0;
        if (weights[currentIdx] <= capacity) {
            profit1 = profits[currentIdx] + dp(profits, weights, capacity - weights[currentIdx], currentIdx + 1);
        }

        // Skip this item: recursive call without item at current idx
        int profit2 = dp(profits, weights, capacity, currentIdx + 1);

        memo[currentIdx][capacity] = Math.max(profit1, profit2);
        return memo[currentIdx][capacity];
    }

    public int solveKnapsackBottomUp(int[] profits, int[] weights, int capacity) {
        // basic checks
        if (capacity <= 0 || profits.length == 0 || weights.length != profits.length)
            return 0;

        int n = profits.length;
        int[][] dp = new int[n][capacity + 1];

        // populate the capacity=0 columns, with '0' capacity we have '0' profit
        for (int i = 0; i < n; i++)
            dp[i][0] = 0;

        // if we have only one weight, we will take it if it is not more than the capacity
        for (int c = 0; c <= capacity; c++) {
            if (weights[0] <= c)
                dp[0][c] = profits[0];
        }

        // process all sub-arrays for all the capacities
        for (int i = 1; i < n; i++) {
            for (int c = 1; c <= capacity; c++) {
                int profit1 = 0;
                int profit2 = 0;
                // include the item, if it is not more than the capacity
                if (weights[i] <= c) {
                    profit1 = profits[i] + dp[i - 1][c - weights[i]];
                }
                // exclude the item
                profit2 = dp[i - 1][c];
                // take maximum
                dp[i][c] = Math.max(profit1, profit2);
            }
        }

        // maximum profit will be at the bottom-right corner.
        return dp[n - 1][capacity];
    }


    public static void main(String[] args) {
        int[] profits = new int[]{1, 6, 10, 16};
        int[] weights = new int[]{1, 2, 3, 5};
        int capacity = 7;
        System.out.println(new ZeroOneKnapsack().solveKnapsackRecursive(profits, weights, capacity));
        System.out.println(new ZeroOneKnapsack().solveKnapsackTopDown(profits, weights, capacity));

    }
}
