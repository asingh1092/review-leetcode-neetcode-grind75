package com.singh.grind.week1;

import java.util.Arrays;
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
        if (src == color) {
            return image;
        }
        stack.add(new int[]{sr, sc});
        while (!stack.isEmpty()) {
            int[] val = stack.pop();
            int row = val[0];
            int col = val[1];
            if (isValid(image, row + 1, col, src)) {
                stack.add(new int[]{row + 1, col});
            }
            if (isValid(image, row - 1, col, src)) {
                stack.add(new int[]{row - 1, col});
            }
            if (isValid(image, row, col + 1, src)) {
                stack.add(new int[]{row, col + 1});
            }
            if (isValid(image, row, col - 1, src)) {
                stack.add(new int[]{row, col- 1});
            }
            image[row][col] = color;
        }
        return image;
    }

    private boolean isValid(int[][] image, int row, int col, int src) {
        return row >= 0 && row < image.length && col >= 0 && col < image[0].length && image[row][col] == src;
    }

    public static void main(String[] args) {
        FloodFill f  = new FloodFill();
        int[][] image = new int[][]{{1,1,1},{1,1,0},{1,0,1}};
        int[][] result = f.floodFill(image, 1, 1, 2);
        for (int[] row : result) {
            System.out.println(Arrays.toString(row));
        }
    }
}
