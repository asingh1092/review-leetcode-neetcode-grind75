package com.singh.neetcode.graphs;

import java.util.Stack;

public class NumberOfIslands {

        /*
            Given an m x n grid which represents a map fo '1's (land) and '0's (water), return the number of islands

            An islands is surrounded by water and is formed by conecting adj lands horizontally or vertically.
            You may assume all four edges of the grid are all surrounded by water

         */

    public int numberOfIslands(char[][] grid) {
        int ret = 0;
        if (grid.length == 0 || grid[0].length == 0) {
            return ret;
        }
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        Stack<int[]> stack = new Stack<>();
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == '1' && !visited[row][col]) {
                    stack.push(new int[]{row, col});
                    dfs(grid, stack, visited);
                    ret++;
                }
            }
        }
        return ret;
    }

    private void dfs(char[][] grid, Stack<int[]> stack, boolean[][] visited) {
        while (!stack.isEmpty()) {
            int[] pos = stack.pop();
            int row = pos[0];
            int col = pos[1];
            visited[row][col] = true;
            // check adj positions
            checkAdj(new int[]{row - 1, col}, grid, stack, visited);
            checkAdj(new int[]{row + 1, col}, grid, stack, visited);
            checkAdj(new int[]{row, col - 1}, grid, stack, visited);
            checkAdj(new int[]{row, col + 1}, grid, stack, visited);
        }
    }

    private void checkAdj(int[] adj, char[][] grid, Stack<int[]> stack, boolean[][] visited) {
        int rows = grid.length;
        int cols = grid[0].length;
        int row = adj[0];
        int col = adj[1];
        // make sure adj pos is 1, not larger than the boundaries, and not visited
        if (row >= 0 && row < rows && col >= 0 && col < cols && grid[row][col] == '1' && !visited[row][col]) {
            stack.push(adj);
        }
    }

    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        NumberOfIslands n = new NumberOfIslands();
        System.out.println(n.numberOfIslands(grid));
    }
}
