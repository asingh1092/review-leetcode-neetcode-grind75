package com.singh.neetcode.graphs;

import java.util.*;

public class RemoveIslands {


    /*
        * m * n array that has either zero or one
        * Zero = white pixel
        * One = black pixel
        * tasked with removing all the black pixels that are not connected to the border of the image
        * and surrounded by zeros
        {{ 1, 0, 0, 0, 0, 0 }
         { 0, 1, 0, 1, 1, 1 }
         { 0, 0, 1, 0, 1, 0 }
         { 1, 1, 0, 0, 1, 0 }
         { 1, 0, 1, 1, 0, 1 }
         { 1, 0, 0, 0, 0, 1 }}

         * find a 1, bfs (queue), try and see if you can get to the border
         * add each 1 to a list
         * add to visited
         * if queue is empty and no border has been reached then all items in list can be turned into 0
     */

    // TODO Almost DONE! finish

    public int[][] removeIslands(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return grid;
        }
        int rows = grid.length;
        int cols = grid.length;
        boolean[][] visited = new boolean[rows][cols];
        Queue<int[]> queue = new ArrayDeque<>();
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == 1 && !visited[row][col]) {
                    List<int[]> potentials = new ArrayList<>();
                    int[] pos = new int[]{row, col};
                    queue.add(pos);
                    visited[row][col] = true;
                    potentials.add(pos);
                    bfs(grid, queue, visited, potentials);
                }
            }
        }
        return grid;
    }

    private void bfs(int[][] grid, Queue<int[]> queue, boolean[][] visited, List<int[]> potentials) {
        boolean first = false;
        boolean second = false;
        boolean third = false;
        boolean fourth = false;

        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int posR = pos[0];
            int posC = pos[1];
            first = checkAdjPos(posR + 1, posC, grid, queue, visited, potentials);
            second = checkAdjPos(posR - 1, posC, grid, queue, visited, potentials);
            third = checkAdjPos(posR, posC + 1, grid, queue, visited, potentials);
            fourth = checkAdjPos(posR, posC - 1, grid, queue, visited, potentials);
        }
        if (!first && !second && !third && !fourth) {
            for (int[] potential : potentials) {
                grid[potential[0]][potential[1]] = 0;
            }
        }
    }

    private boolean checkAdjPos(int adjPosR, int adjPosC, int[][] grid, Queue<int[]> queue, boolean[][] visited, List<int[]> potentials) {
        int rows = grid.length;
        int cols = grid[0].length;
        System.out.println("{R:C}: " + adjPosR + "|" + adjPosC );
        if (
                adjPosR >= 0 &&  // edge
                adjPosC >= 0 &&  // edge
                adjPosR < rows && // edge
                adjPosC < cols && // edge
                grid[adjPosR][adjPosC] == 1 &&
                !visited[adjPosR][adjPosC]
        ) {
            int[] pos = new int[]{adjPosR, adjPosC};
            potentials.add(pos);
            queue.add(pos);
            visited[adjPosR][adjPosC] = true;
            if (adjPosR == 0 || adjPosR == rows - 1 || adjPosC == 0 || adjPosC == cols - 1) {
                return true;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        RemoveIslands is = new RemoveIslands();
        int[][] grid = new int[][]{{1, 0, 0, 0, 0, 0},
                {0, 1, 0, 1, 1, 1},
                {0, 0, 1, 0, 1, 0},
                {1, 1, 0, 0, 1, 0},
                {1, 0, 1, 1, 0, 1},
                {1, 0, 0, 0, 0, 1}};
        is.removeIslands(grid);
        for (int[] row : grid) {
            System.out.println("|");
            for (int n : row) {
                System.out.print(n);
            }
        }
    }
}
