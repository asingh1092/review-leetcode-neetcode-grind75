package com.singh.grind.week1;

import java.util.Stack;

public class FloodFill {

    /*
        BFS problem
        First search all 4 points are it, add to stack if same color, else ignore
        Change curr pos to color
        pop stack and do algo again until stack is empty
        retur image
     */
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        Stack<int[]> stack = new Stack<>();
        int src = image[sr][sc];
        if (isValid(image, sr + 1, sc,

    }

    private boolean isValid(int[][] image, int row, int col, int src, int val) {
        return row >= 0 && row < image.length && col >= 0 && col < image[0].length && src == val;
    }
}
