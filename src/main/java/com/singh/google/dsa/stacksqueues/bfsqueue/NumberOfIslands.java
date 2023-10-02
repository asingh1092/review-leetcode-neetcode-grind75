package com.singh.google.dsa.stacksqueues.bfsqueue;

import java.util.ArrayDeque;
import java.util.Queue;

public class NumberOfIslands {

    /*
        Given an m x n 2D binary grid [grid] which represents a map of '1's (land) and '0' (water), return the number of islands.

        An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You
        may assume four edges of the grid are all surrounded by water.
                 0 0  0  0  0  0 0
        e.g.     0 1  1  1  1  0 0
                 0 1  1  0  1  0 0   ->   1                    An position can be a part of an island if at some point we either hit a 0 or an edge
                 0 1  1  0  0  0 0
                 0 0  0  0  0  0 0

                [''1'',''1'',''0'',''0'',''0''],
                [''1'',''1'',''0'',''0'',''0''],  -> 3
                [''0'',''0'',''1'',''0'',''0''],
                [''0'',''0'',''0'',''1'',''1'']

                # 1. find all positions that could be part of an island and add to queue
                # 2. go through queue and check if position is part of an island
                # 3. if I can still go to an adj position, then we're still on the same island
                     if we can't move anymore, then that's an island
     */

    public int numIslands(char[][] grid) {
        int islands = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        Queue<Integer[]> queue = new ArrayDeque<>();
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == '1' && !visited[row][col]) {
                    // do bfs here
                    queue.add(new Integer[]{row, col});
                    visited[row][col] = true;
                    bfs(grid, queue, visited);
                    islands += 1;
                }
            }
        }
        return islands;
    }

    private void bfs(char[][] grid, Queue<Integer[]> queue, boolean[][] visited) {
        // check to see if we've got a 1 around us and add to queue
        while (!queue.isEmpty()) {
            for (int i = 0; i < queue.size(); i++) {
                Integer[] pos = queue.poll();
                int posR = pos[0];
                int posC = pos[1];
                // check all 4 directions
                checkAdjPosForLand(new Integer[]{posR + 1, posC}, grid, queue, visited);
                checkAdjPosForLand(new Integer[]{posR - 1, posC}, grid, queue, visited);
                checkAdjPosForLand(new Integer[]{posR, posC + 1}, grid, queue, visited);
                checkAdjPosForLand(new Integer[]{posR, posC - 1}, grid, queue, visited);
            }
        }
    }

    private void checkAdjPosForLand(Integer[] adjPos, char[][] grid, Queue<Integer[]> queue, boolean[][] visited) {
        int r = adjPos[0];
        int c = adjPos[1];
        int rows = grid.length;
        int cols = grid[0].length;
        if (r >= 0 && c >= 0 && r < rows && c < cols && grid[r][c] == '1' && !visited[r][c]) {
            queue.add(adjPos);
            visited[r][c] = true;
        }
    }

    public static void main(String[] args) {
        char[][] grid = new char[][]{{
                '1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}};
        NumberOfIslands n = new NumberOfIslands();
        System.out.println(n.numIslands(grid));
    }
}
