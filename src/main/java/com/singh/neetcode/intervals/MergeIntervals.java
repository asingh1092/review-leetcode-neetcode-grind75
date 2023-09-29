package com.singh.neetcode.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

    /*
        [1,3] [2,6] [8,10] [15,18]
                        ^   ^


        [1,4],[4,5]
               ^ ^
     */

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int size = intervals.length;
        if (size <= 1) {
            return intervals;
        }
        List<int[]> result = new ArrayList<>();

        int prev = 0;
        int next = 1;
        while (next < size) {
            // condition where they don't overlap
            if (intervals[next][0] > intervals[prev][1]) {
                result.add(intervals[prev]);
            } else {
                // combine the two intervals
                intervals[next][0] = Math.min(intervals[next][0], intervals[prev][0]);
                intervals[next][1] = Math.max(intervals[next][1], intervals[prev][1]);
            }
            prev++;
            next++;
        }
        // add last
        result.add(intervals[prev]);
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1, 4}, {0, 2}, {3, 5}};
        System.out.println(Arrays.deepToString(new MergeIntervals().merge(intervals)));
    }
}
