package com.singh.neetcode.dp;

public class Fibonacci {

    public int fibonacciTopDown(int n) {
        int[] memo = new int[n + 1];
        return topDownFib(n, memo);
    }

    private int topDownFib(int n, int[] memo) {
        if (n < 2) {
            return n;
        }
        if (memo[n] != 0) {
            return memo[n];
        }
        memo[n] = topDownFib(n - 1, memo) + topDownFib(n - 2, memo);
        return memo[n];
    }

    public int fibonacciBottomUp(int n) {
        int[] tabulation  = new int[n + 1];
        tabulation[0] = 0;
        tabulation[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            tabulation[i] = tabulation[i - 1] + tabulation[i - 2];
        }
        return tabulation[n];
    }

    public static void main(String[] args) {
        System.out.println(new Fibonacci().fibonacciTopDown(10));
        System.out.println(new Fibonacci().fibonacciTopDown(3));
        System.out.println(new Fibonacci().fibonacciBottomUp(10));
        System.out.println(new Fibonacci().fibonacciBottomUp(3));
    }
}
