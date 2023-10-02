package com.singh.google.dsa.stacksqueues.queue;

import java.util.ArrayDeque;
import java.util.Queue;

public class MovingAverage {


    Queue<Integer> queue = new ArrayDeque<>();
    int average = 0;
    public MovingAverage(int size) {
        queue.add(size);
        average = size;
    }

    /*
     * @param val: An integer
     * @return:
     */
    public double next(int val) {
        queue.add(val);
        average = (average + val) / queue.size();
        return average;
    }
}

class QueueNode {

    int val;
    QueueNode next;

    QueueNode(int val) {
        this.val = val;
    }

    QueueNode(int val, QueueNode next) {
        this.val = val;
        this.next = next;
    }
}
