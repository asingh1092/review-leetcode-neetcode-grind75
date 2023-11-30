package com.singh.old.neetcode.intervals;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {

    /*
        YOu are given an array of non-overlapping intervals where intervals[i] = [start_i, end_i]
        and the intervals is sorted in ascending order by start_i.

        Merge overlapping intervals

        [1,3], [6, 9] new = [2,5]
           ^
        [1,2] [4,5] [6,7] [8,10] [12,16]  new = [3,4]
           ^

        result = new List
        for interval i in intervals
            if end_n < start_i:
                 add n to result
                 newinterval = i
            else if end_i < start_n
                add i to result
            else
                start_n = min(start_n, start_i)
                end_n = max(end_n, end_i)
        add last n
        result -> array
     */

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        // Iterate through all slots
        for (int[] slot : intervals) {

            // if newInterval before slot insert newInterval & update slot as new interval
            if (newInterval[1] < slot[0]) {
                result.add(newInterval);
                newInterval = slot;

            // if slot is lesser than new Interval insert slot
            } else if (slot[1] < newInterval[0]) {
                result.add(slot);

            // if above conditions fail it's an overlap since possibility of new interval existing in left & right of slot is checked
            // update lowest of start & highest of end & not insert
            } else {
                newInterval[0] = Math.min(newInterval[0], slot[0]);
                newInterval[1] = Math.max(newInterval[1], slot[1]);
            }
        }
        // add last interval
        result.add(newInterval);
        // convert
        return result.toArray(new int[result.size()][]);
    }

}
