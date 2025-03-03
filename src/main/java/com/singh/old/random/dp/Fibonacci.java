package com.singh.old.random.dp;

public class Fibonacci {

    public int fibonacci(int n) {
        if (n < 0) {
            return -1;
        }
        if (n < 2) {
            return n;
        }
        int[] memo = new int[n + 1];
        memo[0] = 0;
        memo[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }
        return memo[n];
    }
}
