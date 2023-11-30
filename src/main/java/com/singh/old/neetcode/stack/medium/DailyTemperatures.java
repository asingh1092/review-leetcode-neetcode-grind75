package com.singh.old.neetcode.stack.medium;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {

    /*
        Given an array of integers temperatures represents the daily temperatures return an array answer such that
        answer[i] is the number of days you have to wait after the ith day to get a warmer temperature.

        If there is no future day for which this is possible, keep answer[i] == 0 instead.

        Ex 1. temperatures = [73, 74, 75, 71, 69, 72, 76, 73]
                             [ 1,  1,  4,  2,  1,  1,  0,  0]

                              80, 79, 78 , 76, 75, 74, 73 ]   Time: O(n) < O(n(n-1)*(n - 2)*...*O(n - n + 1)) < O(n^2)
                                                              Space: O(1)

          // TODO - use a monotonic stack

         [73, 74, 75, 71, 72, 76, 73]
          ^
         [0,   0,   0  0,  0,  0,  0]
         [1]

         [73] -> [0]
         [72,73] -> [1, 0]
         [73,72] -> [0,0]
     */

    public int[] dailyTemperatures(int[] temperatures) {
        int size = temperatures.length;
        int[] answer = new int[size];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < size; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int idx = stack.pop();
                answer[idx] = i - idx;
            }
            stack.push(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        DailyTemperatures dt = new DailyTemperatures();
        System.out.println(Arrays.toString(dt.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
    }
}
