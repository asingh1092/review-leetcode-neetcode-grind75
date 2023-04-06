package com.singh.neetcode.binarysearch;

public class SearchA2DMatrix {

    /*
        Given an [m x n] integer matrix 'matrix' with the following properties:
            * Each row is sorted in non-drecreasing order.
            * The first integer of each row is greater than the last integer of the previous row.
        Given an integer target, return true if target is in matrix or false otherwise.
        You must write a solution in O(log(m*n)) time complexity.
                0   1   2   3
             0  1   3   5   7
             1 10  11  16  20
             2 23  30  34  60
     */

    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        int rowSize = matrix[0].length;
        int col = 0;
        int colSize = matrix.length;
        int mid = colSize - row;
        while (row < colSize) {
            // check
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1,3,6, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };
    }
}
