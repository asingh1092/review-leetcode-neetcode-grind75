package com.singh.google.dsa.stacksqueues.bfsqueue;

import java.util.ArrayDeque;
import java.util.Queue;

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
        boolean[][] visited = new boolean[rows][cols];
        Queue<Integer[]> queue = new ArrayDeque<>();

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (rooms[row][col] == 0) {
                    queue.add(new Integer[]{row, col});
                    visited[row][col] = true;
                }
            }
        }

        int dist = 0;
        while (!queue.isEmpty()) {
            for (int i = 0; i < queue.size(); i++) {
                Integer[] pos = queue.poll();
                int posR = pos[0];
                int posC = pos[1];
                rooms[posR][posC] = dist;
                // check all 4 sides
                checkAdjRoom(new Integer[]{posR + 1, posC}, rooms, queue, visited);
                checkAdjRoom(new Integer[]{posR - 1, posC}, rooms, queue, visited);
                checkAdjRoom(new Integer[]{posR, posC + 1}, rooms, queue, visited);
                checkAdjRoom(new Integer[]{posR, posC - 1}, rooms, queue, visited);
            }
            dist += 1;
        }
    }

    private void checkAdjRoom(Integer[] adjRoom, int[][] rooms, Queue<Integer[]> queue, boolean[][] visited) {
        int adjR  = adjRoom[0];
        int adjC = adjRoom[1];
        int rows = rooms.length;
        int cols = rooms[0].length;
        if (adjR < 0 || adjR == rows || adjC < 0 || adjC == cols || visited[adjR][adjC] || rooms[adjR][adjC] == -1) {
            return;
        }
        visited[adjR][adjC] = true;
        queue.add(new Integer[]{adjR, adjC});
    }

    public static void main(String[] args) {
        int[][] rooms = new int[][]{{2147483647,-1,0,2147483647},{2147483647,2147483647,2147483647,-1},{2147483647,-1,2147483647,-1},{0,-1,2147483647,2147483647}};
        WallsAndGates w = new WallsAndGates();
        for (int[] room : rooms) {
            for (int n : room) {
                System.out.print(n + ", ");
            }
            System.out.print("|");
        }        w.wallsAndGates(rooms);
        for (int[] room : rooms) {
            for (int n : room) {
                System.out.print(n + ", ");
            }
            System.out.print("|");
        }
    }
}

