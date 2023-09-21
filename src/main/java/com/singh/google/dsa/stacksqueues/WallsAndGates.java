package com.singh.google.dsa.stacksqueues;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class WallsAndGates {

    /*      M x N
           I -1  0  I         3  -1  0   1
           I  I  I -1    ->   2   2  1  -1
           I -1  I -1         1  -1  2  -1
           0 -1  I  I         0  -1  3   4

           0  -1         ->    0  -1           0    -1
           I   I               1   2           |
                                               1 <-  2

        BFS with queue

     */

    public void wallsAndGates(int[][] rooms) {
        if (rooms.length == 0 || rooms[0].length == 0) {
            return;
        }
        int rows = rooms.length;
        int cols = rooms[0].length;
        Set<Pair> visited = new HashSet<>();
        Queue<Pair> queue = new ArrayDeque<>();

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (rooms[row][col] == 0) {
                    Pair gate = new Pair(row, col);
                    queue.add(gate);
                    visited.add(gate);
                }
            }
        }

        int dist = 0;
        while (!queue.isEmpty()) {
            for (int i = 0; i < queue.size(); i++) {
                Pair gate = queue.poll();
                rooms[gate.r][gate.c] = dist;
                addRoom(new Pair(gate.r + 1, gate.c), rows, cols, visited, rooms, queue);
                addRoom(new Pair(gate.r - 1, gate.c), rows, cols, visited, rooms, queue);
                addRoom(new Pair(gate.r, gate.c + 1), rows, cols, visited, rooms, queue);
                addRoom(new Pair(gate.r, gate.c - 1), rows, cols, visited, rooms, queue);
            }
            dist += 1;
        }
    }

    private void addRoom(Pair adjRoom, int rows, int cols, Set<Pair> visited, int[][] rooms, Queue<Pair> queue) {
        if (adjRoom.r < 0 || adjRoom.r == rows || adjRoom.c < 0 || adjRoom.c == cols || visited.contains(adjRoom) || rooms[adjRoom.r][adjRoom.c] == -1) {
            return;
        }
        visited.add(adjRoom);
        queue.add(adjRoom);
    }
}

