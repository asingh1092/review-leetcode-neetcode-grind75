package com.singh.old.neetcode.arrayshashing;

import java.util.*;

public class FibonacciSequence {

    /*
        0,1,1,2,3,5,8,.....n

        fib(0) = 0
        fib(1) = 1
        fib(2) = fib(0) + fib(1)
        fib(n) = fib(n-1) + fib(n-2)

        save time using a memo map of fib we've solved at the cost of space

     */

    public static List<Integer> fib(int n) {
        List<Integer> ret = new ArrayList<>();
        ret.add(0);
        ret.add(1);
        for (int i = 2; i < n; i++) {
            int value = ret.get(i - 2) + ret.get(i - 1);
            ret.add(value);
        }
        return ret;
    }

    public static long fibMemo(long n) {
        Map<Long, Long> memo = new HashMap<>();
        memo.put(0L, 0L);
        memo.put(1L, 1L);
        return helper(memo, n);
    }

    private static long helper(Map<Long, Long> memo, long n) {
        if (memo.containsKey(n)) {
            return memo.get(n);
        } else {
            long value = (helper(memo, n - 1) + helper(memo, n - 2));
            memo.put(n, value);
            return value;
        }
    }

    public static void main(String[] args) {
        System.out.println(fibMemo(20));
    }
}
