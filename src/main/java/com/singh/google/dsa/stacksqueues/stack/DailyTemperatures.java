package com.singh.google.dsa.stacksqueues.stack;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {

    /*
        Monotonic stack in a stack whose elements are monotonically increasing or decreasing. It contains all qualities
        that a typical stack has and its elements are all monotonic decreasing or increasing.
            * has a range of queries in an array situation
            * the minima/maxima elements
            * when an element is popped from the monotonic stack, it will never be utilized again.

         * mainly the PREVIOUS/NEXT SMALLER/LARGER problem where monotonicity is remained

         Given an array of integers temperatures representing the daily temperatures, return an array answer such that
         answer[i] is the number of days you have to wait after the ith day to get a warmer temperature. If there is no
         future day for which this is possible, keep answer[i] == 0;

               [72, 74, 75, 71, 69, 72, 76, 73]
                     ^
                0    1
     */

    public int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int idx = stack.pop();
                answer[idx] = i - idx;
            }
            stack.push(i);
        }
        return answer;
    }
}
