package com.singh.neetcode.stack.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class CarFleet {

    /*
        There are n cars going to the same destination along a one-lane road. The destination is target miles away.

        You are given two integer array position and speed, both of length n, where position[i] is the position of
        the ith car and speed[i] is the speed of the ith car (in mph).

        A car can never pass another car ahead of it, but it can catch up to it and drive bumper to bumper at the same
        speed. The faster car will slow down to match the slower car's speed. The distance between these two cars is
        ignored (i.e, they are assumed to have the same position).

        A car fleet is some non-empty set of cars driving at the same position and same speed.
            Note - a single car is its own fleet

        Return the number of car fleets that will arrive at the destination

        Ex. 1 -> target = 12, position = [10, 8, 0, 5, 3] speed = [2, 4, 1, 1, 3]

        -------------------------------------------------------------------------
        0       3             5                   8                  10        target
        1       3             1                   4                   2         12

        (12 - 10) / 2 = 1 turn
        (12 - 8)  / 4 = 1 turn
        (12 - 5) / 1 = 7  turns
        (12 - 3) / 3 = 3  turns
        (12 - 0) / 1 = 12 turns

        turns = [1, 1, 12, 7, 3]
        [0, 3, 5, 8, 10]
         1  3  1  4   2
              @turn 3  @turn 1
     */
    public int carFleet(int target, int[] positions, int[] speeds) {
        int fleets = 0;
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> hMap = new HashMap<>(); // <Position, speed>
        for (int i = 0; i < positions.length; i++) {
            hMap.put(positions[i], speeds[i]);
        }
        Arrays.sort(positions);
        for (int i = 0; i < positions.length; i++) {
        }

        return fleets;
    }
}
