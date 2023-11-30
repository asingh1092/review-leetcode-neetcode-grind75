package com.singh.old.neetcode.intervals;

import java.util.*;
public class MeetingRooms {
    public boolean canAttendMeetings(List<Interval> intervals) {
        // assume sorted????
        if (intervals.size() <= 1) {
            return true;
        }
        int prev = 0;
        int next = 1;
        while (next < intervals.size()) {
            if (intervals.get(prev).end > intervals.get(next).start) {
                return false;
            }
            next++;
        }
        return true;
    }

    public static void main(String[] args) {
        Interval one = new Interval(0, 30);
        Interval two = new Interval(5, 10);
        Interval three = new Interval(15, 20);
        Interval four = new Interval(5, 8);
        Interval five = new Interval(9, 15);
        MeetingRooms meetingRooms = new MeetingRooms();
        System.out.println(meetingRooms.canAttendMeetings(List.of(one, two, three)));
        System.out.println(meetingRooms.canAttendMeetings(List.of(four, five)));
    }
}
