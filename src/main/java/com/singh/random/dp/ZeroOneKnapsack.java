package com.singh.random.dp;

public class ZeroOneKnapsack {

    /*
            profits[]
            weights[]
            capacity

            maximize profit
            knapsack(0) -> 0
            knapsack(1) -> 1
     */

    public int knapsack(int[] profits, int[] weights, int capacity) {
        if (profits.length == 0 || weights.length == 0 || capacity == 0) {
            return 0;
        }
        return dp(profits, weights, capacity, 0);
    }

    public int dp(int[] profits, int[] weights, int capacity, int index) {
        // base check
        if (capacity <= 0 || index >= profits.length) {
            return 0;
        } else {
            int profitsWith = 0;
            if (weights[index] <= capacity) {
                profitsWith = profits[index] + dp(profits, weights, capacity - weights[index], index + 1);
            }
            int profitsWithout = dp(profits, weights, capacity, index + 1);
            return Math.max(profitsWith ,profitsWithout);
        }
    }

    public static void main(String[] args) {
        int[] profits = new int[]{1, 6, 10, 16};
        int[] weights = new int[]{1, 2, 3, 5};
        int capacity = 7;
        ZeroOneKnapsack z = new ZeroOneKnapsack();
        System.out.println(z.knapsack(profits, weights, capacity));
    }
}
