package com.singh.random.dp;

public class UnboundedKnapsack {

    /*

     */

    public int unbounded(int[] profits, int[] weights, int capacity) {
        return dp(profits, weights, capacity);
    }

    private int dp(int[] profits, int[] weights, int left) {
        int max = 0;
        for (int i = 0; i < profits.length; i++) {
            if (weights[i] <= left) {
                max = Math.max(max, profits[i] + dp(profits, weights, left - weights[i]));
            }
        }
        return max;
    }
}
